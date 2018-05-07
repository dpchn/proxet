package com.proxet.api.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proxet.api.form.CompaignRuleForm;
import com.proxet.api.service.DeviceService;

@RestController
@RequestMapping("/company")
public class DeviceListController {

	@Autowired
	DeviceService deviceService;
	/*@GetMapping("/company/check")
    public @ResponseBody List<Map<String, Object>> getSearchResultViaAjax(@Valid @RequestBody CompaignRuleForm form,HttpServletRequest request, Errors errors) {
		int companyId = (int)request.getSession().getAttribute("id");
		List<Map<String, Object>> list = deviceService.getDeviceList(2);
        System.out.println("Hello");
        return list;
    }
	*/
	 @GetMapping("/search")
	    public @ResponseBody String getSearchResultViaAjax(@RequestBody CompaignRuleForm form,HttpServletRequest request, Errors errors) {

	        System.out.println("Hello");
	        
	        
	        return "dfhsoidfh";
	    }
}
