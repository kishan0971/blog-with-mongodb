package com.in2it.blogmongo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.in2it.blogmongo.model.Comment;
import com.in2it.blogmongo.model.Like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogDto {
	
	private long id;
	private String title;
	private String content;
	private String visiblity;
	private List<String> media;
	private int commentsCount;
	private int likesCount;
	private List<Like> likes;
	private List<Comment> comments;
	private List<String> tags;
	private long authorId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	

}
