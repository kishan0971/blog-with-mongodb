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

import com.in2it.blogmongo.helper.UploadFileHelper;
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
	
	@Autowired
	UploadFileHelper fileHelper;
	
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
	public Blog addBlog(String title, String content, String visiblity, List<MultipartFile> media, String authorid, List<String> tags) {

		List<String> uploadedMedia = new ArrayList<>();

		if(media != null && !media.isEmpty()) {
			for (MultipartFile file : media) {
				try {
					String uploadMedia = fileService.uploadMedia(path, file);
					String uploadFile = fileHelper.uploadFile(file);
					System.out.println("upload media "+ uploadMedia);
					System.out.println("uploaded file "+ uploadFile);
//					uploadedMedia.add(uploadMedia);
					uploadedMedia.add(uploadFile)
;				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
		}
		
		Blog blog = Blog.builder()
				
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
		.status("ACTIVE")
		.media(uploadedMedia)
		.build();
		
		
		
		return repository.save(blog);
	}

	@Override
	public Blog getBlogByBlogId(String blogId) {
		
		return repository.findById(blogId).orElseThrow(()-> new RuntimeException("Data dosen't exist with given id... "+ blogId));
	}

	@Override
	public List<Blog> getBlogsByAuthorId(String authorId) {
		
		return repository.findByAuthorIdAndStatus(authorId, "ACTIVE");
	}

	@Override
	public List<Blog> getBlogsByTitle(String title) {
		
//		return repository.findByTitleAndStatus(title, "ACTIVE");
		return repository.findByStatusAndTitleContaining("ACTIVE", title);
	}

	@Override
	public Blog updateBlog(String blogId, String title, String content, String visiblity, List<String> tags) {
		Blog blog = repository.findById(blogId).orElseThrow(()-> new RuntimeException("Blog dosen't exist with given id"));
		if(blog != null) {
			blog.setTitle(title);
			blog.setContent(content);
			blog.setVisiblity(visiblity);
			blog.setTags(tags);
			blog.setUpdatedAt(LocalDateTime.now());	
	
		}
		
		return repository.save(blog);
	}

	@Override
	public Blog deleteBlog(String blogId) {
		Blog blog = repository.findById(blogId).orElseThrow(()-> new RuntimeException("Blog dosen't exist with given id"));
		if(blog!=null) {
			blog.setStatus("INACTIVE");
			blog.setDeletedAt(LocalDateTime.now());
		}
		return repository.save(blog);
	}

	@Override
	public List<Blog> getAllActiveBlogs() {
		
		return repository.findByStatus("ACTIVE");
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
