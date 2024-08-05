package com.in2it.blogmongo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "blogs")
public class Blog {
	
	@Id
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
	private String status="ACTIVE";
	private Long deletedById;
	private LocalDateTime deletedAt;
	
	
}
