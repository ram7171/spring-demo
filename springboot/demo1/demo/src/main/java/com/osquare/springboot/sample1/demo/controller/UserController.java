package com.osquare.springboot.sample1.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.osquare.springboot.sample1.demo.dao.UserDao;
import com.osquare.springboot.sample1.demo.domain.User;
import com.osquare.springboot.sample1.demo.exception.UserNotFoundException;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * By Default request and response type is application/json format.
 * if we want to change and support the xml type, then need to add jackson-xml data 
 * dependency in pom.xml file
 * 
 * By default request-header is application/json, we can this by Accept - application/xml
 * @author ram
 *
 */

@RestController
public class UserController {

	@Autowired
	UserDao userService;
	
	@GetMapping(path="/getall-user")
	public List<User> getAllUser() {
		return userService.findAll();
	}
	
	
	@GetMapping(path="/getuser-byid/{id}")
	public Resource<User> getUserBuId(@PathVariable int id) {
		User user = userService.getById(id);
		if(user == null) {
			throw new UserNotFoundException("id does not exists" + id);
		}
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).
				getAllUser());
		resource.add(linkTo.withRel("all-user"));
		return resource;
	}
	
	@PostMapping(path="/create-user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		userService.saveUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/deleteuser-byid/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
		User user = userService.deleteUser(id);
		if(user == null) {
			throw new UserNotFoundException("id does not exists ->" + id);
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.noContent().build();
	}
}
