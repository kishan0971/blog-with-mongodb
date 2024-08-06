package com.in2it.blogmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogmongo.model.Blog;
import com.in2it.blogmongo.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {

	@Autowired
	BlogService service;

	@PostMapping
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		System.out.println(blog.getTitle() + "title in controller");
		Blog savedBlog = service.createBlog(blog);
		return ResponseEntity.ok(savedBlog);
	}

	@PostMapping(path = "/add-blog", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	 
	public Blog addBlog( @RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("visiblity") String visiblity,
			@RequestParam("authorid") Long authorid, @RequestParam List<String> tags, @RequestParam("media") List<MultipartFile> media) {
		
		System.out.println("data :  title "+title+" content "+content+" visiblity "+visiblity+" authorid "+authorid+" tags "+tags+" media "+media);
			
		return service.addBlog(title, content, visiblity, media, authorid, tags);
		

//		return "Done";
	}

	@GetMapping
	public ResponseEntity<List<Blog>> getAllBlogs() {
		List<Blog> allBlogs = service.getAllBlogs();
		return ResponseEntity.ok(allBlogs);
	}

}
