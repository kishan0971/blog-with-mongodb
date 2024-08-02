package com.in2it.blogmongo.model;

import java.time.LocalDateTime;

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
@Document(collection = "likes")
public class Like {
	
	
	@Id
	private Long id;
	private String type;
	private long blogId;
	private long authorId;
	private LocalDateTime createdAt;

}
