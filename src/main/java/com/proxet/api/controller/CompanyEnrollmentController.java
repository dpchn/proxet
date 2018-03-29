package com.proxet.api.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class CompanyEnrollmentController {

	@Autowired
	CompanyService companyService;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			ModelMap model) {
		model.addAttribute("name", name);
		System.out.println("GRETTINGS, " + name + "................!");
		return "greeting";
	}

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
			BindingResult result, Model model) {
		System.out.println("enroll");
		if (result.hasErrors()) {
		//	System.out.println(result.);
			System.out.println("Erroo");
			System.out.println(result);
			return "enroll";
		}
		HashMap<String, String> map = companyService.saveEnroll(enrollForm.getFirstName(), enrollForm.getLastName(),
				enrollForm.getEmail(), enrollForm.getPassword(), enrollForm.getCompany(), enrollForm.getPhone());
		model.addAttribute("firstName", map.get("firstName"));
		model.addAttribute("email", map.get("email"));
		model.addAttribute("phone", map.get("phone"));
		return "companyprofile";
	}

	@GetMapping("/login")
	public String login(){
		return "compnaylogin";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("CompanyLoginForm") @Validated CompanyLoginForm loginForm,BindingResult result, Model model) {
		Model view = null;
		if(result.hasErrors())
			return "companylogin";
		companyService.login(loginForm.getEmail(), loginForm.getPassword());
		return "companyprofile";
	}

}
