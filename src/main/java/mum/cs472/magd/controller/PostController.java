package mum.cs472.magd.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;




import mum.cs472.magd.entity.Post;
import mum.cs472.magd.service.GlobalService;
import mum.cs472.magd.service.PostService;
import mum.cs472.magd.service.UserService;

import javax.servlet.http.HttpServletResponse;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;


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
	
	@RequestMapping(value ="/getPosts")
	public void getPosts(HttpServletRequest request,Model model,HttpServletResponse response){	
		
		List<Post> posts = new ArrayList<>();
		try{ 
			posts =postService.getPosts();		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try {
			String json =  "" ; 
			json =new Gson().toJson(posts);
			response.getWriter().write("{ \"data\":"   + json + " }");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value ="/listUserPosts")
	public void listUserPosts(HttpServletRequest request,Model model,HttpServletResponse response){	
		
		List posts = new ArrayList();
		try{ 
			posts =postService.listUserPosts();		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try {
			String json =  "" ; 
			json =new Gson().toJson(posts);
			response.getWriter().write("{ \"data\":"   + json + " }");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	
	@RequestMapping(value ="/addSuggestPost")
	public String addSuggestPost(HttpServletRequest request,Model model, 
			@RequestParam("postId") String postId,
			@RequestParam("toUserId") String toUserId){
		
		
		String userId = (String)request.getSession(true).getAttribute("userId");
		boolean flag = false;
		try{ flag =postService.suggestPost(userId, postId, toUserId);
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
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value ="/listSuggestPost")
	public void listSuggestPost(HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		
		
		String userId = (String)request.getSession(true).getAttribute("userId");
		boolean flag = false;
		List post = postService.listSuggestPost(userId);
		String json =  "" ; 
		json =new Gson().toJson(post);
		response.getWriter().write("{ \"data\":"   + json + " }"); 

	}
	
	@RequestMapping(value="/deletePost")
	public String deletePost(HttpServletRequest request, Model model, 
			@RequestParam("postId") String postId){
		
		boolean flag = false;
		try{
			flag = postService.deletePost(postId);
			if(flag){
				model.addAttribute("msg", "Post deleted Succesfully");
			}
			else{
				model.addAttribute("msg", "Error deleting post");
			}
		}catch(Exception ex){}
		return "home";
	}
	
	@RequestMapping(value ="/listMyPosts")
	public void listMyPosts(HttpServletRequest request,Model model,HttpServletResponse response){	
		
		List posts = new ArrayList();
		try{ 
			String userId = (String)request.getSession(true).getAttribute("userId");
			posts = postService.getMyPosts(userId);	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try {
			String json =  "" ; 
			json =new Gson().toJson(posts);
			response.getWriter().write("{ \"data\":"   + json + " }");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	@RequestMapping(value ="/countPosts")
	public void countPosts(HttpServletRequest request,Model model,HttpServletResponse response){	
		
		List posts = new ArrayList();
		try{ 
			posts = postService.countActualPost();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try {
			String json =  "" ; 
			json =new Gson().toJson(posts);
			response.getWriter().write("{ \"data\":"   + json + " }");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
			
}
