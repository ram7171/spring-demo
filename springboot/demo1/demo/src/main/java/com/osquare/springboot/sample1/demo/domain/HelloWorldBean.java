package com.osquare.springboot.sample1.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class HelloWorldBean {
	private String message;	
	
	@Override
	public String toString() {
		return String.format("Hello World Bean [message=%s]", message);
		
	}
}
