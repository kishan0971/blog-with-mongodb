package com.in2it.blogmongo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LikeDto {
	
	
	private Long id;
	private String type;
	private long blogId;
	private long authorId;
	private LocalDateTime createdAt;

}
