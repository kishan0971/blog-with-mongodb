package com.in2it.blogmongo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogmongo.model.Blog;

@Component
public interface BlogService {

	Blog createBlog(Blog blog);
	
//	Blog updateBlog(Blog blog, String blogId);
	
	Blog deleteBlog(String blogId);

	List<Blog> getAllBlogs();
	
	Blog getBlogByBlogId(String blogId);
	
	List<Blog> getBlogsByAuthorId(Long authorId);
	
	List<Blog> getBlogsByTitle(String title);

	Blog addBlog(String title, String content, String visiblity, List<MultipartFile> media, Long authorid, List<String> tags);
	Blog updateBlog(String blogId, String title, String content, String visiblity, List<String> tags);

}
