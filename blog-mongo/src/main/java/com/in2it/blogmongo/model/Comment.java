package com.in2it.blogmongo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "comments")
public class Comment {
	
	@Id
	private Long id;
	private String content;
	private String media;
	private Long blogId;
	private Long authorid;
	private LocalDateTime createdAt;
	private int likesCount;
	private List<Comment> replies;
	private String status="ACTIVE";
	private Long deletedById;
	private LocalDateTime deletedAt;

}
