package com.stackroute.service;

import com.stackroute.domain.Blog;

import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    /**
     * Constructor based Dependency injection to inject BlogRepository here
     */
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

	@Override
	public Blog saveBlog(Blog blog) {
		Blog blogDetails=new Blog();
		blogDetails.setBlogId(blog.getBlogId());
		blogDetails.setBlogTitle(blog.getBlogTitle());
		blogDetails.setAuthorName(blog.getAuthorName());
		blogDetails.setBlogContent(blog.getBlogContent());
		blogRepository.save(blogDetails);
		return blogDetails;
	}

	@Override
	public List<Blog> getAllBlogs() {
		Iterable<Blog> bloggerList = blogRepository.findAll();
		List<Blog> blog = new ArrayList<>();
		bloggerList.forEach(x -> {
			Blog b = new Blog();
			b.setBlogId(x.getBlogId());
			b.setBlogTitle(x.getBlogTitle());
			b.setAuthorName(x.getAuthorName());
			b.setBlogContent(x.getBlogContent());
			blog.add(b);
		});
		
		return blog;
	}

	@Override
	public Blog getBlogById(int id) throws Exception {
		Optional<Blog> option =blogRepository.findById(id);
		Blog blog =option.orElseThrow(()->new Exception("Not Found"));
		return blog;
		
		
	}
	

	@Override
	public Blog deleteBlog(int id) throws Exception {
		Optional<Blog> option=blogRepository.findById(id);
		Blog blog =option.orElseThrow(()->new Exception("Not Found"));
		 blogRepository.delete(blog);	
		return blog;
	}

	@Override
	public Blog updateBlog(Blog blog) throws Exception {
		Optional<Blog> option =blogRepository.findById(blog.getBlogId());
		Blog b=option.orElseThrow(()->new Exception("Not Found"));
		b.setBlogId(blog.getBlogId());
		b.setBlogTitle(blog.getBlogTitle());
		b.setAuthorName(blog.getAuthorName());
		b.setBlogContent(blog.getBlogContent());
		blogRepository.save(b);
		return b;
		
		
	}

}

