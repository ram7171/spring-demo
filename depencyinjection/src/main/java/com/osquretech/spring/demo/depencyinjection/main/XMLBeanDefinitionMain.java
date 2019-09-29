package com.osquretech.spring.demo.depencyinjection.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.osquretech.spring.demo.depencyinjection.xmldemo.Coach;

public class XMLBeanDefinitionMain {
	
	public static void main(String[] args) {
//		Coach coach = new BaseballCoach();
//		System.out.println(coach.getWorkoutTime());
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach coach = context.getBean("myCoach", Coach.class);
		System.out.println(coach.getWorkoutTime());
		
		coach = context.getBean("cricketCoach", Coach.class);
		System.out.println(coach.getWorkoutTime());
		
		coach = context.getBean("golfCoach",Coach.class);
		
//		singleton confirmation
		Coach alphCoach = context.getBean("golfCoach", Coach.class);
		System.out.println(coach == alphCoach );
		System.out.println(" coach->" + coach + " - alpha coach- >" + alphCoach);
		System.out.println(coach.getFortune() + " -- " + coach.getWorkoutTime());
		
//		prototype object creation 
		coach = context.getBean("golfCoachProtoType", Coach.class);
		alphCoach = context.getBean("golfCoachProtoType", Coach.class);
		
		System.out.println("Prototype ->" + coach + " " + alphCoach);
		
		context.close();
	}
}
