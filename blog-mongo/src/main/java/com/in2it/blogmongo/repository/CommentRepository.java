package com.in2it.blogmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.in2it.blogmongo.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

}
