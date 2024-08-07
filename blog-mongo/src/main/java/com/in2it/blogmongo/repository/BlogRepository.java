package com.in2it.blogmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.in2it.blogmongo.model.Blog;
import java.util.List;


@Repository
public interface BlogRepository extends MongoRepository<Blog, String>{
	
	List<Blog> findByAuthorId(long authorId);
	
	List<Blog> findByAuthorIdAndStatus(long authorId, String status);
	
	List<Blog> findByTitleAndStatus(String title, String status);
	
	
	List<Blog> findByStatusAndTitleContaining(String status, String title);
	

}
