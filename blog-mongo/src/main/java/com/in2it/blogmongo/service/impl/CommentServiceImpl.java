package com.in2it.blogmongo.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogmongo.model.Blog;
import com.in2it.blogmongo.model.Comment;
import com.in2it.blogmongo.repository.BlogRepository;
import com.in2it.blogmongo.repository.CommentRepository;
import com.in2it.blogmongo.service.CommentService;
import com.in2it.blogmongo.service.FileService;


@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository repository;
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	FileService fileService;
	
	@Value("${project.media}")
	String path;

	@Override
	public Comment addComment(Comment comment) {
		
		return repository.save(comment);
	}

	@Override
	public List<Comment> getAllComments() {
		
		return repository.findAll();
	}

	@Override
	public Comment commentOnBlog(String content, MultipartFile media, String blogId, Long authorid) {
		
		
		String file = null;
		if(media != null && !media.isEmpty()) {
			
			try {
				file = fileService.uploadMedia(path, media);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		Comment comment = Comment.builder()
				.authorid(authorid)
				.content(content)
				.media(file)
				.blogId(blogId)
				.createdAt(LocalDateTime.now())
				.status("ACTIVE")
				.likes(new ArrayList<>())
				.replies(new ArrayList<>())
				.likesCount(0)
				.deletedAt(null)
				.deletedById(null)
				.build();
		
		
		Comment save = repository.save(comment);
		
		Blog blog = blogRepository.findById(blogId).orElseThrow(()-> new RuntimeException("Blog dosen't Exist"));
		
		List<Comment> comments = blog.getComments();
		comments.add(comment);
		blog.setComments(comments);
		int commentsCount = blog.getCommentsCount()+1;
		blog.setCommentsCount(commentsCount);
		blogRepository.save(blog);
		
		
		
		return save;
	}


}
