package com.easynotes.easynotes.controller;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easynotes.easynotes.model.Category;
import com.easynotes.easynotes.repository.CategoryRepository;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired 
	CategoryRepository categoryRepository;
	
	@GetMapping("/get")
	public List<Category> getBooks() {
		return categoryRepository.findAll();
	}
	
	@PostMapping("/store")
	public Category createCategory(@RequestBody Category category) {
		category.setCreatedAt(LocalDateTime.now());
		return categoryRepository.save(category);
	}
}
