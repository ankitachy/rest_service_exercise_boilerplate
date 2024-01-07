package com.stackroute.service;

import com.stackroute.domain.Blog;

import java.util.List;

public interface BlogService {
     /**
      * AbstractMethod to save a blog
      */
     Blog saveBlog(Blog blog);

     /**
      * AbstractMethod to get all blogs
      */
     List<Blog> getAllBlogs();

     /**
      * AbstractMethod to get blog by id
     * @throws Exception 
      */
     Blog getBlogById(int id) throws Exception;

     /**
      * AbstractMethod to delete blog by id
     * @throws Exception 
      */
     Blog deleteBlog(int id) throws Exception;

     /**
      * AbstractMethod to update a blog
     * @throws Exception 
      */
     Blog updateBlog(Blog blog) throws Exception;
}
