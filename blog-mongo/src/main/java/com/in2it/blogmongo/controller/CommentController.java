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

import com.in2it.blogmongo.model.Comment;
import com.in2it.blogmongo.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	
	@PostMapping
	public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
		
		Comment savedComment = service.addComment(comment);
		return ResponseEntity.ok(savedComment);
	}

	@GetMapping
	public ResponseEntity<List<Comment>> getAllComments() {
		
		List<Comment> allComments = service.getAllComments();
		return ResponseEntity.ok(allComments);
	}
	
	@PostMapping(path =  "/comment-on-blog", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Comment commentOnBlog(@RequestParam("content") String content,@RequestParam(name = "media", required = false) MultipartFile media,@RequestParam("blogId") String blogId,@RequestParam() String authorid) {
		return service.commentOnBlog(content, media, blogId, authorid);
	}
		

}
