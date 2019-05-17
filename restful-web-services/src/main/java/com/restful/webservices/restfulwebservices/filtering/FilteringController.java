package com.restful.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	public FilteringController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/filtering")
	// field1,field2
	public MappingJacksonValue getSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
		jacksonValue.setFilters(filters);
		return jacksonValue;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue getSomeBeanList() {
		List<SomeBean> asList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value11", "value21", "value33"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue jacksonValue = new MappingJacksonValue(asList);
		jacksonValue.setFilters(filters);
		return jacksonValue;
	}
}
