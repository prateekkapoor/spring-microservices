package com.springboot.multimodular2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.springboot.multimodular.repository")
@EntityScan("com.springboot.multimodular.repository")
public class MultiModularApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiModularApplication.class, args);
	}

}
