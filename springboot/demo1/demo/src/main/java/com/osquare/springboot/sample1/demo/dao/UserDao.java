package com.osquare.springboot.sample1.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.osquare.springboot.sample1.demo.domain.User;

@Component
public class UserDao {
	private static List<User> userList = new ArrayList<>();
	private static int counter = 3;
	static {
		userList.add(new User(1, "user1", new Date(),null));
		userList.add(new User(2, "user2", new Date(),null));
		userList.add(new User(3, "user3", new Date(),null));
	}
	
	public List<User> findAll() {
		return userList;
	}
	
	public User getById(int id) {
		for(User user: userList) {
			if(id == user.getId()) {
				return user;
			}
		}
		return null;
	}
	
	public User saveUser(User user) {
		userList.add(new User(++counter, user.getName(), user.getDob(),null));
		user.setId(counter);
		return user;
	}

	public User deleteUser(int id) {
		System.out.println("id --" + id);
		for(User user: userList) {
			System.out.println("getuser id-->" + user.getId());
			if(id == user.getId()) {
				userList.remove(user);
				return user;
			}
		}
		return null;
	}
}
