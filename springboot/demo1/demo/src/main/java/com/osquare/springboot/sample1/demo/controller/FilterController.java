package com.osquare.springboot.sample1.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.osquare.springboot.sample1.demo.domain.SomeBean;
import com.osquare.springboot.sample1.demo.domain.SomeBean2;

@RestController
public class FilterController {

	@GetMapping("/filtering-some-bean")
	public SomeBean getSomeBean() {
		return new SomeBean("value1", "value2", "value3","v4","v5");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> getFilterList() {
		
		return Arrays.asList(new SomeBean("v1", "v2", "v3","v4","v5"),
				new SomeBean("v12", "v13", "v13","v14","v15"));
	}
	
	
	@GetMapping("/filtering-some-bean2")
	public MappingJacksonValue getSomeBean2() {
		SomeBean2 bean = new SomeBean2("value1", "value2", "value3","v4","v5");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value4","value5");
		FilterProvider provider = new SimpleFilterProvider().
				addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(provider);
		return mapping;
		
		
	}
	
	@GetMapping("/filtering-list2")
	public  MappingJacksonValue getFilterList2() {
		
		List<SomeBean2> lst = Arrays.asList(new SomeBean2("v1", "v2", "v3","v4","v5"),
				new SomeBean2("v12", "v13", "v13","v14","v15"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
		FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(lst);
		mapping.setFilters(provider);
		return mapping;
	}
}
