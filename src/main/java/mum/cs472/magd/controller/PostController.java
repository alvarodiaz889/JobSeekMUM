package mum.cs472.magd.controller;

import javax.servlet.http.HttpServletRequest;


import mum.cs472.magd.entity.Post;
import mum.cs472.magd.service.GlobalService;
import mum.cs472.magd.service.PostService;
import mum.cs472.magd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	GlobalService glbSrv;
	public static String errMsg = "";
	
	
	
	@RequestMapping(value ="/addPost")
	public String addPost(HttpServletRequest request,Model model, Post post){
		
		
		String userId = (String)request.getSession(true).getAttribute("userId");
		boolean flag = false;
		try{ flag =postService.insertPost(post,userId);
		if(flag){
			model.addAttribute("msg", "post added successully");
		}
		else{
			model.addAttribute("msg", "post not added ");
		}
		}catch(Exception ex){
			ex.printStackTrace();
			model.addAttribute("msg", "post not added ");
		}
		return "home";
	}
	
	@RequestMapping(value="/deletePost")
	public String deletePost(HttpServletRequest request, Model model, Post post){
		
		boolean flag = false;
		try{
			flag = postService.deletePost(post);
			if(flag){
				model.addAttribute("msg", "Post deleted Succesfully");
			}
			else{
				model.addAttribute("msg", "Error deleting post");
			}
		}catch(Exception ex){}
		return "home";
	}
			
}
