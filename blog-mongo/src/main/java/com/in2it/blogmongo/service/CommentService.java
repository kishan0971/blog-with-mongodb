package com.in2it.blogmongo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.in2it.blogmongo.model.Comment;

@Component
public interface CommentService {

	Comment addComment(Comment comment);
	List<Comment> getAllComments();
}
