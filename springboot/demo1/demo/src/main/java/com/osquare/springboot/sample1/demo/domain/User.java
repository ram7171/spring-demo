package com.osquare.springboot.sample1.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "RTO user information")
@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 2,message = "user name at greater than 4 char")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "The date should be past")
	private Date dob;
//	one user can have many post
	@OneToMany(mappedBy = "user")
	private List<Post> post;
}
