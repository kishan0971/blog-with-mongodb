package com.in2it.blogmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.blogmongo.model.Comment;
import com.in2it.blogmongo.repository.CommentRepository;
import com.in2it.blogmongo.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository repository;

	@Override
	public Comment addComment(Comment comment) {
		
		return repository.save(comment);
	}

	@Override
	public List<Comment> getAllComments() {
		
		return repository.findAll();
	}

}
