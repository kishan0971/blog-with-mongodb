package com.in2it.blogmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.blogmongo.model.Like;
import com.in2it.blogmongo.repository.LikeRepository;
import com.in2it.blogmongo.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	LikeRepository repository;

	@Override
	public Like addLike(Like like) {
		return repository.save(like);
	}

	@Override
	public List<Like> getAllLikes() {
		
		return repository.findAll();
	}

}
