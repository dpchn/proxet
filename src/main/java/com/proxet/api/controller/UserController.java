package com.proxet.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proxet.api.form.UserForm;
import com.proxet.api.model.User;
import com.proxet.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/enroll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody UserForm form, BindingResult result) {

		if (userService.isUserExist(form.getContactNo())) {
			logger.error("Unable to create. A User with name {} already exist");
			return new ResponseEntity("Already Exist", HttpStatus.CONFLICT);
		}
		User user = userService.createUser(form.getfName(), form.getfName(), form.getEmail(), form.getContactNo());

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loginUser(@RequestBody UserForm form, BindingResult result) {
		if (!userService.isUserExist(form.getContactNo())) {
			logger.error("Unable to create. A User with name {} already exist");
			return new ResponseEntity("Already Exist", HttpStatus.CONFLICT);
		}
		User user = userService.loginUser(form.getContactNo());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMappedAdvertisement( HttpServletRequest request) {		
		String deviceId = request.getParameter("id");
		String contactNo = request.getParameter("contactNo");
		System.out.println(deviceId+" "+contactNo);
		if(userService.isContactMappedWithDevice(deviceId, contactNo)){
			return new ResponseEntity<>("Already Mapped", HttpStatus.OK);
		}
		return 	new ResponseEntity<List<?>>(userService.getMappedAdvertisement(deviceId, contactNo, request), HttpStatus.OK);
	}
	
	

}
