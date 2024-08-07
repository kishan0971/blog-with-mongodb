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
public class CommentDto {
	
	private String id;
	private String content;
	private String media;
	private String blogId;
	private String authorid;
	private LocalDateTime createdAt;
	private int likesCount;
	private List<Like> likes;
	private List<Comment> replies;
	private String status;
	private String deletedById;
	private LocalDateTime deletedAt;


}
