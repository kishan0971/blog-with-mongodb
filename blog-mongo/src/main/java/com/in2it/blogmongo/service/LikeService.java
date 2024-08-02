package com.in2it.blogmongo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.in2it.blogmongo.model.Like;

@Component
public interface LikeService {
	
	Like addLike(Like like);
	List<Like> getAllLikes();
	

}
