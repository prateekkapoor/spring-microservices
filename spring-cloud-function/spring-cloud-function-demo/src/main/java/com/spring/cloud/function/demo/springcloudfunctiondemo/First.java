package com.spring.cloud.function.demo.springcloudfunctiondemo;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class First implements Function<String, String> {

	@Override
	public String apply(String input) {
		return input.toUpperCase();
	}

}
