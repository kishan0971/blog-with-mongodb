package com.in2it.blogmongo.service.impl;

import java.nio.file.NoSuchFileException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.blogmongo.model.Blog;
import com.in2it.blogmongo.model.Like;
import com.in2it.blogmongo.repository.BlogRepository;
import com.in2it.blogmongo.repository.LikeRepository;
import com.in2it.blogmongo.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	LikeRepository repository;
	
	@Autowired
	BlogRepository blogRepository;

	@Override
	public Like addLike(Like like) {
		return repository.save(like);
	}

	@Override
	public List<Like> getAllLikes() {
		
		return repository.findAll();
	}

	@Override
	public Like likeBlog(Like like) throws NoSuchFileException {
//		repository.findLikeByAuthorIdAndBlogId(like.getAuthorId(), like.getAuthorId()).isEmpty();
		List<Like> likeByAuthorIdAndBlogId = repository.findLikeByAuthorIdAndBlogId(like.getAuthorId(), like.getBlogId());
		System.out.println(likeByAuthorIdAndBlogId);
		for (Like like2 : likeByAuthorIdAndBlogId) {
			System.out.println(like2);
		}
		
		if(likeByAuthorIdAndBlogId.isEmpty()) {
			
			Blog blog = blogRepository.findById(like.getBlogId()).orElseThrow(()-> new NoSuchFileException("No such element Found"));
			
			List<Like> likes = blog.getLikes();
			
			like.setCreatedAt(LocalDateTime.now());
			Like like2 = repository.save(like);
			likes.add(like2);
			blog.setLikes(likes);
			int likeCount = blog.getLikesCount()+1;
			blog.setLikesCount(likeCount);
			blogRepository.save(blog);
			return like2;
		}
		return null;
		
		
	}

}
