package com.osquretech.spring.demo.service.impl;

import java.util.Random;

import com.osquretech.spring.demo.service.FortuneService;

public class RandomFurtunate implements FortuneService {

	private String[] data = {"First data in array",
			"second element in array",
			"Third element in array"};
	Random rand = new Random();
	
	public String getFurtunate() {
		return data[rand.nextInt(data.length)];
	}

}
