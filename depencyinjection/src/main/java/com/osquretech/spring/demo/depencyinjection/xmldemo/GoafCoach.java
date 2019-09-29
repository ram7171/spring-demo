package com.osquretech.spring.demo.depencyinjection.xmldemo;

import com.osquretech.spring.demo.service.FortuneService;

public class GoafCoach implements Coach {

	private FortuneService service;
	public GoafCoach(FortuneService service) {
		this.service = service;
	}
	
	public String getWorkoutTime() {
		return "Goal Coach pracitice is now happening";
	}

	public String getFortune() {
		return this.service.getFurtunate();
	}

	
}
