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
	
	private String id;
	private String title;
	private String content;
	private String visiblity;
	private Long departmentId;
	private Long teamId;
	private List<String> media;
	private int commentsCount;
	private int likesCount;
	private List<Like> likes;
	private List<Comment> comments;
	private List<String> tags;
	private String authorId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String status;
	private Long deletedById;
	private LocalDateTime deletedAt;
	
	

}
