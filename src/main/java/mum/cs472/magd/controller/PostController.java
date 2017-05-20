package mum.cs472.magd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mum.cs472.magd.entity.Post;
import mum.cs472.magd.entity.User;
import mum.cs472.magd.service.PostService;
import mum.cs472.magd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
	
	@RequestMapping(value="post")
	public String viewPost(HttpServletRequest request,Model model,
			@RequestParam("password")String password,
			@RequestParam("email") String email
			){
		
		String url ="";
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		List<Post> posts = new ArrayList<>();
		posts = postService.getPosts();
		boolean flag =userService.isValid(user);
		if(flag){
			url ="post";
			model.addAttribute("posts", posts);
		
		}
		else{
			url = "home";
			model.addAttribute("msg", "Invalid Username/Password");}
		return url;
	}
	
	@RequestMapping(value ="/addPost",params = {"postText!="})
	public String addPost(HttpServletRequest request,Model model, @RequestParam(required=true)String postText){
		
		String userSessionId = "123123";
		Post post = new Post();
		post.setPostText(postText);
		boolean flag =postService.insertPost(post, userSessionId);
		if(flag){
			model.addAttribute("msg", "post added successully");
		}
		else{
			model.addAttribute("msg", "post not added ");
		}
		return "post";
	}
			
}
