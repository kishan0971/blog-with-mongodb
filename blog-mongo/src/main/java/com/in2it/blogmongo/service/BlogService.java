package com.in2it.blogmongo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogmongo.model.Blog;

@Component
public interface BlogService {

	Blog createBlog(Blog blog);

	List<Blog> getAllBlogs();

	Blog addBlog(Long id , String title, String content, String visiblity, List<MultipartFile> media, Long authorid, List<String> tags);
//	Blog addBlog(String title, String content, String visiblity, MultipartFile[] media, Long authorid, List<String> tags);

}
