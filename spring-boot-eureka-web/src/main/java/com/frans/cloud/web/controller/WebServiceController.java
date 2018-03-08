package com.frans.cloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frans.cloud.web.service.EurekaClientService;

@Controller
public class WebServiceController {
	
	private EurekaClientService eurekaClientService;	

	public WebServiceController(EurekaClientService eurekaClientService) {
		this.eurekaClientService = eurekaClientService;
	}


	@RequestMapping("/welcome")
	public String getPlayers(Model model){
		model.addAttribute("title",eurekaClientService.getWelcomeMessage());
		return "welcome";
	}
}
