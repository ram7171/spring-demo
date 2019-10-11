package com.osquare.springboot.sample1.demo.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDetails {
	private Date timestamp;
	private String message;
	private String details;
}
