package com.demo.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.microservices.currencyconversionservice.bean.ConversionBean;
import com.demo.microservices.currencyconversionservice.feignclient.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean getCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<ConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", ConversionBean.class, uriVariables);
		ConversionBean response = responseEntity.getBody();
		ConversionBean conversionBean = new ConversionBean(response.getId(), from, to, response.getConversionMultiple(),
				quantity, quantity.multiply(response.getConversionMultiple()), 0);
		return conversionBean;
	}

	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean getCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		ConversionBean response = currencyExchangeServiceProxy.getExchangeConversion(from, to);
		ConversionBean conversionBean = new ConversionBean(response.getId(), from, to, response.getConversionMultiple(),
				quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
		logger.info("Response: {}", conversionBean);
		return conversionBean;
	}
}
