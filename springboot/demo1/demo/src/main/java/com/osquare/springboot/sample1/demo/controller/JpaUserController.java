package com.osquare.springboot.sample1.demo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.osquare.springboot.sample1.demo.dao.UserJpaDao;
import com.osquare.springboot.sample1.demo.domain.Post;
import com.osquare.springboot.sample1.demo.domain.User;
import com.osquare.springboot.sample1.demo.exception.UserNotFoundException;
import com.osquare.springboot.sample1.demo.repository.PostRepository;
import com.osquare.springboot.sample1.demo.repository.UserRepository;

@RestController
public class JpaUserController {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping(path="/jpa/getall-user")
	public List<User> getAllUser() {
		return repository.findAll();
	}
	
	@GetMapping(path="/jpa/getuser-byid/{id}")
	public Resource<User> getUserBuId(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id does not exists" + id);
		}
		
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).
				getAllUser());
		resource.add(linkTo.withRel("all-user"));
		return resource;
	}
	
	@PostMapping(path="/jpa/create-user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		repository.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/jpa/deleteuser-byid/{id}")
	public void deleteUserById(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/jpa/user/{id}/post")
	public List<Post> retrievePostByUser(@PathVariable int id) {
		Optional<User> optional = repository.findById(id);
		
		if(!optional.isPresent()) {
			throw new UserNotFoundException("id does not exists" + id);
		}
		
		return optional.get().getPost();
	}
	
	@PostMapping(path="/jpa/create-post/{id}/post")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOptional = repository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id does not exists" + id);
		}
		
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}















