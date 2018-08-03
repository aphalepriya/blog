package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class BlogMockedData {

	private List<Blog> blogs;
	
	private static BlogMockedData instance = null;
	public static BlogMockedData getInstance() {
		if (instance==null)
			instance=new BlogMockedData();
		return instance;
	}
	
	public BlogMockedData() {
		blogs = new ArrayList<Blog>();
		
		blogs.add(new Blog(1,"Title Number 1"));
		blogs.add(new Blog(2,"Title Number 2"));
		blogs.add(new Blog(3,"Title Number 3"));
		blogs.add(new Blog(4,"Title Number 4"));
		blogs.add(new Blog(5,"Title Number 5"));
	}
	
	public List<Blog> fetchBlogs(){
		return blogs;
	}
	
	public Blog getBlogById(int id) {
		for(Blog b: blogs)
			if(b.getId()==id)
				return b;
		return null;
	}
	
	public List<Blog> searchBlogs(String searchTerm) {
		List<Blog> searchedBlogs = new ArrayList<Blog>();
		
		for(Blog b: blogs)
			if(b.getTitle().toLowerCase().contains(searchTerm.toLowerCase()))
				searchedBlogs.add(b);
		return searchedBlogs;
	}
	
	public Blog createBlog(int id, String title) {
		Blog newBlog = new Blog(id,title);
		blogs.add(newBlog);
		return newBlog;
	}
	
	public Blog updateBlog(int id, String title) {
		for(Blog b: blogs)
			if(b.getId()==id) {
				int blogIndex = blogs.indexOf(b);
				b.setTitle(title);
				blogs.set(blogIndex,b);
				return b;
			}
		return null;
	}
	
	public boolean deleteBlog(int id) {
		int blogIndex = -1;
		for(Blog b:blogs) {
			if(b.getId()==id) {
				blogIndex = blogs.indexOf(b);
				continue;
			}
		}
		if(blogIndex>-1)
			blogs.remove(blogIndex);
		return true;
	}
}
