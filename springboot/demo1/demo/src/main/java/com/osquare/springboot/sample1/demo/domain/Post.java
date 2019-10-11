package com.osquare.springboot.sample1.demo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	
//	many to one - means many post can have single user
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
}
