package com.spring.cloud.function.aws.serverless.demo;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

@Component
public class First implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	@Override
	public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent input) {
		APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
		responseEvent.setStatusCode(200);
		responseEvent.setBody("HELLO WORLD");
		return responseEvent;
	}

}
