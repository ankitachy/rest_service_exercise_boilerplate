package com.stackroute.controller;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */

/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RestController
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

  
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
    	Blog blogger=blogService.saveBlog(blog);
    	
    	return new ResponseEntity<Blog>(blogger,HttpStatus.OK);
    }

    /**
     * retrieve all blogs
     */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
    	List<Blog> blogs=blogService.getAllBlogs();
    	return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }

    /**
     * retrieve blog by id
     * @throws Exception 
     */
    @GetMapping("blog/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") int blogId) throws Exception {
    	Blog blog=blogService.getBlogById(blogId);
    	return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }

    /**
     * delete blog by id
     * @throws Exception 
     */
    @DeleteMapping("blog/{blogId}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable("blogId") int blogId) throws Exception {
    	Blog blog =blogService.deleteBlog(blogId);
    	return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }


    /**
     * update blog
     * @throws Exception 
     */
    @PutMapping("blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) throws Exception {
    	Blog blogger=blogService.updateBlog(blog);
    	return new ResponseEntity<Blog>(blogger,HttpStatus.OK);
    }
}