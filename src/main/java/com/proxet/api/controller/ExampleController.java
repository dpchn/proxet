package com.proxet.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {

	@RequestMapping("/hello")
	public ResponseEntity getMessage(){
		System.out.println("Hellos");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
