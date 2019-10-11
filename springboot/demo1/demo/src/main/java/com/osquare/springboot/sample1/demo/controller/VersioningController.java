package com.osquare.springboot.sample1.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osquare.springboot.sample1.demo.domain.versioning.Name;
import com.osquare.springboot.sample1.demo.domain.versioning.PersonV1;
import com.osquare.springboot.sample1.demo.domain.versioning.PersonV2;

@RestController
public class VersioningController {

	@GetMapping("/persion/v1")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}
	//uri vresioning
	@GetMapping("/persion/v2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "charlie"));
	}
	
	@GetMapping(value="/persion/param",params="version=1")
	public PersonV1 param1() {
		return new PersonV1("Bob Charlie");
	}
	//url parameter versioning
	@GetMapping(value="/persion/param",params="version=2")
	public PersonV2 param2() {
		return new PersonV2(new Name("Bob", "charlie"));
	}
	
	@GetMapping(value="/persion/header",headers = "X-API-HEADER=1")
	public PersonV1 headerParam1() {
		return new PersonV1("Bob Charlie");
	}
	
	//custom header versioning
	//add X-API-HEADER = 2 in request header
	@GetMapping(value="/persion/header",headers = "X-API-HEADER=2")
	public PersonV2 headerParam2() {
		return new PersonV2(new Name("Bob", "charlie"));
	}
	
//	Media type versioning 
	@GetMapping(value="/person/produces",produces = "application/vnd.company.app-v1+json")
	public PersonV1 produces1() {
		return new PersonV1("Bob Charlie");
	}
	
	
	//add Accept = vnd.company.app-v2+json in request header
	@GetMapping(value="/person/produces",produces = "application/vnd.company.app-v2+json")
	public PersonV2 produces2() {
		return new PersonV2(new Name("Bob", "charlie"));
	}
	
}
