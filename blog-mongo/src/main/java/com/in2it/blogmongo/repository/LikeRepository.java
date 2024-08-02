package com.in2it.blogmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.in2it.blogmongo.model.Like;

@Repository
public interface LikeRepository extends MongoRepository<Like, Long>{

}
