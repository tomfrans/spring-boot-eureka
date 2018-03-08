package com.frans.cloud.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.frans.cloud.web.controller.WebServiceController;
import com.frans.cloud.web.service.EurekaClientService;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootEurekaWebApplication {
	
	// Case insensitive: could also use: http://eureka-client
    public static final String CLIENT_SERVICE_URL
                                        = "http://EUREKA-CLIENT";

	public static void main(String[] args) {
		 System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(SpringBootEurekaWebApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public EurekaClientService eurekaClientService(){
		return new EurekaClientService(CLIENT_SERVICE_URL);
	}
	
	@Bean
	public WebServiceController webServiceController(){
		return new WebServiceController(eurekaClientService());
	}
}
