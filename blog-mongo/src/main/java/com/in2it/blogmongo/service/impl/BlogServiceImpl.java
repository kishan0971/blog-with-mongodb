package com.in2it.blogmongo.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogmongo.model.Blog;
import com.in2it.blogmongo.repository.BlogRepository;
import com.in2it.blogmongo.service.BlogService;
import com.in2it.blogmongo.service.FileService;


@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	BlogRepository repository;
	
	@Autowired
	FileService fileService;
	
	@Value("${project.media}")
	String path;

	@Override
	public Blog createBlog(Blog blog) {
		System.out.println(blog.getTitle()+"title in service");
		return repository.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		
		return repository.findAll();
	}

	@Override
	public Blog addBlog(Long id, String title, String content, String visiblity, List<MultipartFile> media, Long authorid, List<String> tags) {
//		public Blog addBlog(String title, String content, String visiblity, MultipartFile[] media, Long authorid, List<String> tags) {
		List<String> uploadedMedia = new ArrayList<>();
		
//		uploadedImages = media.stream().map( file-> {
//			try {
//				return fileService.uploadMedia(path, file);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return file.getOriginalFilename();
//		} ).collect(Collectors.toList());
		
		for (MultipartFile file : media) {
			try {
				String uploadMedia = fileService.uploadMedia(path, file);
				uploadedMedia.add(uploadMedia);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		Blog blog = Blog.builder()
				
		.id(id)
		.title(title)
		.content(content)
		.visiblity(visiblity)
		.authorId(authorid)
		.tags(tags)
		.createdAt(LocalDateTime.now())
		.commentsCount(0)
		.likesCount(0)
		.likes(new ArrayList<>())
		.comments(new ArrayList<>())
		.status("Active")
		.media(uploadedMedia)
		.build();
		
		
		
		return repository.save(blog);
	}
	
	
	

}
