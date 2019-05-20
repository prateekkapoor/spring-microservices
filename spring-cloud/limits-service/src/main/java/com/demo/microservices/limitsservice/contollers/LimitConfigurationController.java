package com.demo.microservices.limitsservice.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.limitsservice.bean.LimitConfiguration;
import com.demo.microservices.limitsservice.configuration.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitConfigurationController {

	@Autowired
	Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration getLimitConfiguration() {
		return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}

	@GetMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallBackRetrieveConfiguration")
	public LimitConfiguration retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}

	public LimitConfiguration fallBackRetrieveConfiguration() {
		return new LimitConfiguration(1, 100);
	}
}
