package com.restful.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public static final Contact DEFAULT_CONTACT = new Contact("", "", "");
	public static final ApiInfo DEFAULT = new ApiInfo("Api Documentation for awesomec code",
			"Api Documentation for awesome code decription", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> PRODUCES_CONSUMES_MEDIA_TYPES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	public SwaggerConfig() {
		// TODO Auto-generated constructor stub
	}

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).consumes(PRODUCES_CONSUMES_MEDIA_TYPES)
				.produces(PRODUCES_CONSUMES_MEDIA_TYPES);
	}

}
