package com.proxet.api.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.proxet.api.form.AdCompaignForm;
import com.proxet.api.form.AdContentForm;
import com.proxet.api.form.CompaignRuleForm;
import com.proxet.api.form.CompanyEnrollmentForm;
import com.proxet.api.form.CompanyLoginForm;
import com.proxet.api.form.DeviceForm;
import com.proxet.api.service.CompaignRuleService;
import com.proxet.api.service.CompaignService;
import com.proxet.api.service.CompanyService;
import com.proxet.api.service.ContentService;
import com.proxet.api.service.DeviceService;
import com.proxet.api.util.ImageFileAndSave;import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@RequestMapping("/company")
public class CompanyController {

	private static Logger logger = LoggerFactory.getLogger(CompanyController.class);
	@Autowired
	CompanyService companyService;
	@Autowired
	DeviceService deviceService;
	@Autowired
	ContentService contentService;
	@Autowired
	CompaignService compaignService;
	@Autowired
	CompaignRuleService compaignRuleService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/**
	 * 
	 * Company Enroll get request
	 */
	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public String register() {
		return "companyenroll";
	}

	/**
	 * 
	 * Company Enroll post request
	 */
	@PostMapping(value = "/enroll")
	public String enroll(@ModelAttribute("CompanyEnrollmentForm") @Valid CompanyEnrollmentForm enrollForm,
			BindingResult result, Model model, HttpServletRequest request) {
		System.out.println("enroll");
		if (result.hasErrors()) {
			System.out.println(result);
			result.reject("dummy");
			return "companyenroll";
		}
		int id = companyService.saveEnroll(enrollForm.getFirstName(), enrollForm.getLastName(), enrollForm.getEmail(),
				enrollForm.getPassword(), enrollForm.getCompany(), enrollForm.getPhone());
		request.getSession().setAttribute("id", id);
		return "companyprofile";
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("compnaylogin");
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("CompanyLoginForm") @Validated CompanyLoginForm loginForm, BindingResult result,
			Model model, HttpServletRequest request) {
		if (result.hasErrors())
			return "companylogin";
		if (companyService.login(loginForm.getEmail(), loginForm.getPassword(), request) == null)
			return "companylogin";
		// companyService.login(loginForm.getEmail(), loginForm.getPassword());
		return "companyprofile";
	}

	@GetMapping("/companyProfile")
	public ModelAndView companyProfile(HttpRequest request) {
		ModelAndView view = new ModelAndView("companyprofile");
		return view;
	}
	
	@GetMapping("/devices")
	public ModelAndView getDevices(HttpServletRequest request) {
		int companyId = (int)request.getSession().getAttribute("id");
		List<Map<String, Object>> list = deviceService.getDeviceList(companyId);
		ModelAndView view = new ModelAndView("device");
		view.addObject("deviceList", list);
		return view;
	}

	@PostMapping("/addDevice")
	public ModelAndView addDevice(HttpServletRequest request,
			@ModelAttribute("deviceForm") @Validated DeviceForm deviceForm) {
		System.out.println(request.getSession().getAttributeNames());
		int id = (int) request.getSession().getAttribute("id");
		System.out.println("Requestid : " + id);
		ModelAndView view = new ModelAndView("device");
		List<Map<String, Object>> list = deviceService.AddDevices(deviceForm.getDeviceId(), deviceForm.getLocation(),
				id);
		view.addObject("deviceList", list);
		return view;
	}

	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public ModelAndView addContent(HttpServletRequest request) {
		int companyId = (int)request.getSession().getAttribute("id");
		ModelAndView view = new ModelAndView("content");
		List<Map<String, Object>> list = contentService.getAllAdContents(companyId);
		view.addObject("contentData", list);
		return view;
	}

	@PostMapping("/addContent")
	public ModelAndView addAdContent(@ModelAttribute("adContentForm") @Validated AdContentForm contentForm,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		int companyId = (int) request.getSession().getAttribute("id");
		ModelAndView view = new ModelAndView("content");
		String filePath = new ImageFileAndSave().saveImageFile(file);
		List<Map<String, Object>> list=contentService.addContent(filePath, contentForm.getContentType(), contentForm.getName(), contentForm.getShortNotification(), contentForm.getLongNotification(), companyId);
		view.addObject("contentData", list);
		return view;
	}

	@GetMapping(value = "/compaigns")
	public ModelAndView addCompaign(HttpServletRequest request) {
	//	int companyId = (int)request.getSession().getAttribute("id");
		List<Map<String, Object>> list = compaignService.getCompaignList(2);
		ModelAndView view = new ModelAndView("compaign");
		view.addObject("compaignList", list);
		return view;
	}

	@PostMapping("/addCompaign")
	public ModelAndView addAdCompaign(@ModelAttribute("adCompaignForm") AdCompaignForm compaignForm,
			HttpServletRequest request) {
		//int companyId = (int) request.getSession().getAttribute("id");
		List<Map<String, Object>> list = compaignService.addCompaign(request, compaignForm.getTitle(), compaignForm.getStartDate(),
				compaignForm.getEndDate(), compaignForm.getStartTime(), compaignForm.getEndTime(), 2);
		ModelAndView view = new ModelAndView("compaign");
		view.addObject("compaignList", list);
		return view;
	}

	@GetMapping("/compaignRule")
	public ModelAndView addAdCompaignRule(HttpServletRequest request) {
		int compaignId = Integer.valueOf(request.getParameter("id"));
		request.getSession().setAttribute("compaignId", compaignId);
		List<Map<String, Object>> list=deviceService.getDeviceList(2);
		Map<String, Object> ruleDetail =compaignRuleService.getCompaignRule(compaignId); 
		ModelAndView view = new ModelAndView("compaignRule");
		view.addObject("deviceList", list);
		view.addObject("ruleDetail", ruleDetail);
		return view;
	}

	@PostMapping("/addCompaignRule")
	public ModelAndView addAdCompaignRule(@ModelAttribute("compaignRuleForm") CompaignRuleForm compaignRuleForm,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView("compaignRule");
		//int companyId = (int) request.getSession().getAttribute("id");
		int compaignId = Integer.valueOf((String) request.getSession().getAttribute("compaignId"));
		compaignRuleService.addCompaignRule(compaignRuleForm.getTitle(),compaignRuleForm.getContentType(), compaignRuleForm.getStartTime(),
				compaignRuleForm.getEndTime(), compaignRuleForm.getDevices(), compaignRuleForm.getDays(),compaignRuleForm.getShowContent(),compaignRuleForm.getFrequency(), 2, compaignId);
		return view;
	}

}
