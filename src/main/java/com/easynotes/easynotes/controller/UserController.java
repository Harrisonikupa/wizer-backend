package com.easynotes.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easynotes.easynotes.model.Category;
import com.easynotes.easynotes.model.User;
import com.easynotes.easynotes.repository.CategoryRepository;
import com.easynotes.easynotes.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired 
	UserRepository userRepository;
	
	@GetMapping("/get")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/store")
	public User createUser(@RequestBody User request) {
		return userRepository.save(request);
	}
}
