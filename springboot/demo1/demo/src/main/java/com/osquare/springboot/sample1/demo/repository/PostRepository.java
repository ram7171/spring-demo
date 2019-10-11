package com.osquare.springboot.sample1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osquare.springboot.sample1.demo.domain.Post;
import com.osquare.springboot.sample1.demo.domain.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
}
