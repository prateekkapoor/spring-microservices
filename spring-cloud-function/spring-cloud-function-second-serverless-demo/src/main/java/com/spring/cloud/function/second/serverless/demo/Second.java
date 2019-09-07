package com.spring.cloud.function.second.serverless.demo;

import java.io.IOException;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Second implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

private static final Logger log = LoggerFactory.getLogger(Second.class);

	@Override
	public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent input) {
		APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
		log.info("Input", input);
		log.info("Input Body", input.getBody());
		Hello hello = readValue(input.getBody());
		hello.setGreetings(hello.getGreetings().toUpperCase());
		String response = writeValue(hello);
		responseEvent.setStatusCode(200);
		responseEvent.setBody(response);
		return responseEvent;
	}

	private Hello readValue(String input) {
		ObjectMapper mapper = new ObjectMapper();
		Hello hello = null;
		try {
			hello = mapper.readValue(input, Hello.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hello;

	}
	
	private String writeValue(Hello output) {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		try {
			result = mapper.writeValueAsString(output);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
