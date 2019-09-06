package com.spring.cloud.function.demo.springcloudfunctiondemo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudFunctionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionDemoApplication.class, args);
	}
@Bean
public Function<String, String> upperCase(){
	return input-> input.toUpperCase();
	
}
@Bean
public Consumer<String> consumer(){
	return input->{System.out.println("Decorated Text "+input);
	};
}

@Bean
public Supplier<String> supplier(){
	return ()-> "Hello World";
}
}
