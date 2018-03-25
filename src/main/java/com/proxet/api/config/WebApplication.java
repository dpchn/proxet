package com.proxet.api.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//@EnableAutoConfiguration 
//@SpringBootApplication
@SpringBootApplication(scanBasePackages={"com.proxet.api.controller","com.proxet.api.service"})
public class WebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(WebApplication.class);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
