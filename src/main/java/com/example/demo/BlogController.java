package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
	
	BlogMockedData bmd = BlogMockedData.getInstance();
	
	@GetMapping("/blog")
	public List<Blog> index(){
		return bmd.fetchBlogs();
	}
	
	@GetMapping("/blog/{id}")
	public Blog show(@PathVariable String id) {
		int blogId = Integer.parseInt(id);
		return bmd.getBlogById(blogId);
	}
	
	@PostMapping("/blog/search")
	public List<Blog> search(@RequestBody Map<String, String> body){
		String searchTerm = body.get("text");
		return bmd.searchBlogs(searchTerm);
	}
	
}
