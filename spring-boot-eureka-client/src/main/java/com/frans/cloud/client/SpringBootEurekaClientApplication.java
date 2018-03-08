package com.frans.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootEurekaClientApplication {

	public static void main(String[] args) {
		// Will configure using accounts-server.yml
        System.setProperty("spring.config.name", "eureka-client");
		SpringApplication.run(SpringBootEurekaClientApplication.class, args);
	}
}
