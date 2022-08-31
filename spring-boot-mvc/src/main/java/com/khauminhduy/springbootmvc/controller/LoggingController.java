package com.khauminhduy.springbootmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

	@GetMapping("/")
	public String index() {
		return "Howdy! Check out the Logs to see the output...";
	}
	
}
