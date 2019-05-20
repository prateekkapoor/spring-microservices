package com.demo.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.demo.microservices.currencyexchangeservice.repository.ExchangevalueRepository;

@RestController
public class CurrencyExchangeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private Environment environment;

	@Autowired
	private ExchangevalueRepository exchangevalueRepository;

	/*
	 * 
	 * http://localhost:8000/currency-exchange/from/USD/to/INR
	 */
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeConversion(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exchangevalueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("Response: {}", exchangeValue);
		return exchangeValue;
	}
}
