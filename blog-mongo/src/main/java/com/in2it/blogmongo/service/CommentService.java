package com.in2it.blogmongo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogmongo.model.Comment;

@Component
public interface CommentService {

	Comment addComment(Comment comment);
	List<Comment> getAllComments();
	
	Comment commentOnBlog(String content, MultipartFile media, Long blogId, Long authorid);
	
}
