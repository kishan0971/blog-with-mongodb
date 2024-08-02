package com.in2it.blogmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.blogmongo.model.Blog;
import com.in2it.blogmongo.repository.BlogRepository;
import com.in2it.blogmongo.service.BlogService;


@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	BlogRepository repository;

	@Override
	public Blog createBlog(Blog blog) {
		System.out.println(blog.getTitle()+"title in service");
		return repository.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		
		return repository.findAll();
	}
	
	
	

}
