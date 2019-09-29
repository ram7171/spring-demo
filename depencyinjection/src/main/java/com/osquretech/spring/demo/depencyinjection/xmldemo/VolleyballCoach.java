package com.osquretech.spring.demo.depencyinjection.xmldemo;

public class VolleyballCoach implements Coach {

	private String practiceWorkout;
	private String todayFortune;
	
	private String prob1;
	private String team;
	
	public String getWorkoutTime() {
		return practiceWorkout;
	}

	public String getFortune() {
		return todayFortune + "| " + prob1 + " | " + team;
	}

	public void setProb1(String prob1) {
		this.prob1 = prob1;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setPracticeWorkout(String practiceWorkout) {
		this.practiceWorkout = practiceWorkout;
	}

	public void setTodayFortune(String todayFortune) {
		this.todayFortune = todayFortune;
	}
}
