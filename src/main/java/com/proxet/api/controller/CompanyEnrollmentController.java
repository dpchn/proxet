package com.proxet.api.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proxet.api.form.CompanyEnrollmentForm;
import com.proxet.api.form.CompanyLoginForm;
import com.proxet.api.service.CompanyService;

@Controller
@RequestMapping("/view")
public class CompanyEnrollmentController {
	
	@Autowired 
	CompanyService companyService;
	
	 @RequestMapping("/greeting")
	    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, ModelMap model) {
	        model.addAttribute("name", name);
	        System.out.println("GRETTINGS, "+ name +"................!");
	        return "greeting";
	    }
	 
	@RequestMapping(value="/reg",method  = RequestMethod.GET)
	public String register(ModelAndView model){
		System.out.println("Hello");
		//model = new ModelAndView("register");
		return "register";
	}
	@RequestMapping(value="/enroll", method=RequestMethod.POST)
	public HashMap<String, String> enroll(@ModelAttribute("CompanyEnrollmentForm") CompanyEnrollmentForm enrollForm){
		 HashMap<String, String> map = companyService.saveEnroll(enrollForm.getFirstName(), enrollForm.getLastName(), enrollForm.getEmail(), enrollForm.getPassword(), enrollForm.getCompany());
		return map;
	}
	
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute("CompanyLoginForm") CompanyLoginForm loginForm){
		Model view=null;
		companyService.login(loginForm.getEmail(), loginForm.getPassword());
		//view.addAttribute("email", companyService.login(loginForm.getEmail(), loginForm.getPassword()));
		//view.addObject(companyService.login(loginForm.getEmail(), loginForm.getPassword()));
		return "Hello";
	}
}
