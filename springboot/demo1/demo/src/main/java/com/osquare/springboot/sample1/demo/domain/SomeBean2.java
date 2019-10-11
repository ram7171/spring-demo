package com.osquare.springboot.sample1.demo.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonFilter("SomeBeanFilter")
public class SomeBean2 {
	private String value1;
	private String value2;
	private String value3;
	private String value4;
	private String value5;
}
