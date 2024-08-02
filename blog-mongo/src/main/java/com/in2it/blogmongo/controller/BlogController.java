package com.in2it.blogmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in2it.blogmongo.model.Blog;
import com.in2it.blogmongo.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
	BlogService service;
	
	@PostMapping
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		System.out.println(blog.getTitle()+"title in controller");
		 Blog savedBlog = service.createBlog(blog);
		 return ResponseEntity.ok(savedBlog);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Blog>> getAllBlogs(){
		List<Blog> allBlogs = service.getAllBlogs();
		return ResponseEntity.ok(allBlogs);
	}

}
