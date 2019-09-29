package com.osquretech.spring.demo.depencyinjection.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.osquretech.spring.demo.depencyinjection.xmldemo.Coach;

public class XMLBeanSetterMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach coach = context.getBean("volleyBallCoach", Coach.class);
		System.out.println(coach.getFortune() + " == " + coach.getWorkoutTime());
		
		
		context.close();
	}

}
