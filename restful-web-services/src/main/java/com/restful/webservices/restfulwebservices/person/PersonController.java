package com.restful.webservices.restfulwebservices.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping("/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("John Doe");
	}

	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Blade", "Runner"));
	}

	@GetMapping(value = "person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("John Doe");
	}

	@GetMapping(value = "person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Blade", "Runner"));
	}

	@GetMapping(value = "person/header", headers = "X-API-Version=1")
	public PersonV1 headerV1() {
		return new PersonV1("John Doe");
	}

	@GetMapping(value = "person/header", headers = "X-API-Version=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Blade", "Runner"));
	}

	@GetMapping(value = "person/produces", produces = { "application/vnd.api+json",
			"application/vnd.company.api-v1+json" })
	public PersonV1 producesV1() {
		return new PersonV1("John Doe");
	}

	@GetMapping(value = "person/produces", produces = { "application/vnd.api+json",
			"application/vnd.company.api-v2+json" })
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Blade", "Runner"));
	}
}
