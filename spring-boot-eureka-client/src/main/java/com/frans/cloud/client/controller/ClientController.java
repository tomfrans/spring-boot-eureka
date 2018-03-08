package com.frans.cloud.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@RequestMapping(value="/message")
	public String getWelcomeMessage(){
		
		return "Eureka Client invokation successful";
	}
}
