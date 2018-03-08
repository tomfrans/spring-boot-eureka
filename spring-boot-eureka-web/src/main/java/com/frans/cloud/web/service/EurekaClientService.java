package com.frans.cloud.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EurekaClientService {

	@Autowired
	@LoadBalanced
    protected RestTemplate restTemplate; 

    protected String serviceUrl;

    public EurekaClientService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public String getWelcomeMessage() {
        String welcome = this.restTemplate.getForObject(serviceUrl + "/message", String.class);
        return welcome;
    }
}
