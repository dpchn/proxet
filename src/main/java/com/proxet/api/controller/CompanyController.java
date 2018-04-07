package com.proxet.api.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proxet.api.form.CompanyEnrollmentForm;
import com.proxet.api.form.CompanyLoginForm;
import com.proxet.api.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	private static Logger logger = LoggerFactory.getLogger(CompanyController.class);
	@Autowired
	CompanyService companyService;

	/**
	 * 
	 *Company Enroll get request 
	 */
	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public String register() {
		return "companyenroll";
	}

	/**
	 * 
	 *Company Enroll post request 
	 */
	@PostMapping(value = "/enroll")
	public String enroll(@ModelAttribute("CompanyEnrollmentForm") @Valid CompanyEnrollmentForm enrollForm,
			BindingResult result, Model model, HttpServletRequest request) {
		System.out.println("enroll");
		if (result.hasErrors()) {
			System.out.println(result);
			result.reject( "dummy");
			return "companyenroll";
		}
		int id = companyService.saveEnroll(enrollForm.getFirstName(), enrollForm.getLastName(),
				enrollForm.getEmail(), enrollForm.getPassword(), enrollForm.getCompany(), enrollForm.getPhone());
		request.getSession().setAttribute("id", id);
		return "companyprofile";
	}

	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView view = new ModelAndView("compnaylogin");
		return view;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("CompanyLoginForm") @Validated CompanyLoginForm loginForm,BindingResult result, Model model) {
		Model view = null;
		if(result.hasErrors())
			return "companylogin";
		if(companyService.login(loginForm.getEmail(), loginForm.getPassword())==null)
			return "companylogin";
		//companyService.login(loginForm.getEmail(), loginForm.getPassword());
		return "companyprofile";
	}
	
	@GetMapping("/companyProfile")
	public ModelAndView companyProfile(HttpRequest request){
		ModelAndView view = new ModelAndView("companyprofile");
		return view;
	}
	
	@GetMapping("/addDevice/{id}")
	public ModelAndView addDevice(HttpServletRequest request, @PathVariable("id") String deviceIds){
		System.out.println(request.getSession().getAttributeNames());
		int id = (int) request.getSession().getAttribute("id");
		System.out.println("Requestid : "+id);
		companyService.AddDevices(deviceIds, id);
		ModelAndView view = new ModelAndView("companyprofile");
		return view;
	}
	
	@PostMapping("/addAdContent")
	public ModelAndView addAdContent(HttpRequest request){
		ModelAndView view = new ModelAndView("companyprofile");
		return view;
	}
	
	@PostMapping("/addAdCompaign")
	public ModelAndView addAdCompaign(HttpRequest request){
		ModelAndView view = new ModelAndView("companyprofile");
		return view;
	}
	
	
	@PostMapping("/addAdCompaignRule")
	public ModelAndView addAdCompaignRule(HttpRequest request){
		ModelAndView view = new ModelAndView("companyprofile");
		return view;
	}
	
}
