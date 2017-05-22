package mum.cs472.magd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import mum.cs472.magd.entity.*;
import mum.cs472.magd.service.*;

@Controller
public class LikeController {
		
	@Autowired
	private LikeService likeService;
	@Autowired
	GlobalService glbSrv;
	public static String errMsg = "";
	
	@RequestMapping(value ="/getLikes")
	public void getLikes(HttpServletRequest request,Model model,HttpServletResponse response,
			@RequestParam("postId") String postId){	
		
		List<User> userLikes = new ArrayList<>();
		try{ 
			userLikes =likeService.viewUsersPerPost(postId);	
			String json =  "" ; 
			json =new Gson().toJson(userLikes);
			System.out.println(json);
			response.getWriter().write("{ \"data\":"   + json + " }");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	@RequestMapping(value ="/setLike")
	public void setLike(HttpServletRequest request,Model model,	HttpServletResponse response,
			@RequestParam("postId") String postId
		     ){	
		String userId = (String)request.getSession(true).getAttribute("userId");
		try{ 
			likeService.like(postId,userId);
			List<Like> likes = likeService.getLastLike(postId, userId);
			String json =  "" ; 
			json =new Gson().toJson(likes);
			System.out.println(json);
			response.getWriter().write("{ \"data\":"   + json + " }"); 
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		
	}
	
	@RequestMapping(value ="/unLike")
	public String unLike(HttpServletRequest request,Model model,@RequestParam("likeId") String likeId){	
				
		try{ 
			likeService.unlike(likeId);		
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return "home";
	}

}
