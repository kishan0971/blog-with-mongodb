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
	
	private Long id;
	private String content;
	private String media;
	private Long blogId;
	private Long authorid;
	private LocalDateTime createdAt;
	private int likesCount;
	private List<Comment> replies;

}
