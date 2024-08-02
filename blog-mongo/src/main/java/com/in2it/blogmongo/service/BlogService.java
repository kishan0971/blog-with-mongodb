package com.in2it.blogmongo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.in2it.blogmongo.model.Blog;

@Component
public interface BlogService {
	
	Blog createBlog(Blog blog);
	List<Blog> getAllBlogs();

}
