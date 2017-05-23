package mum.cs472.magd.controller;

import java.io.IOException;
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

import mum.cs472.magd.entity.Comment;
import mum.cs472.magd.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/viewComment")
	public void viewComments(HttpServletRequest request, Model model, HttpServletResponse response, @RequestParam("postId") String postId) throws IOException{
		
		List<Comment> comments = new ArrayList<>();
		try{
		comments = commentService.viewComments(postId);
		if(null!=comments&& comments.size()>0){
			model.addAttribute("comments", comments);
		}
		else{
			model.addAttribute("msg", "No comments found !");
		}
		}catch(Exception e){e.printStackTrace();}
		try {
			String json =  "" ; 
			json =new Gson().toJson(comments);
			response.getWriter().write("{ \"data\":"   + json + " }"); 
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//response.getWriter().write("{ \"data\":\"ok\" }"); 

	}
	
	@RequestMapping("/addComment")
	public void addComment(HttpServletRequest request, Model model, 
			@RequestParam("postId") String postId,@RequestParam("comment") String comment){
		
		boolean flag  = false;
		String userId = (String)request.getSession(true).getAttribute("userId");
		try{
		flag = commentService.addComment(comment, postId, userId);
		if(flag){
			model.addAttribute("msg", "Comment Added Successfully");
		}
		else{
			model.addAttribute("msg", "Error adding Comment");
		}
		}catch(Exception ex){ex.printStackTrace();}
		
	}
	
	@RequestMapping(value="/deleteComment")
	public String deleteComment(HttpServletRequest request,Model model, @RequestParam("commentId") String commentId){
		boolean flag = false;
		String msg = "";
		try{
			flag = commentService.deleteComment(commentId);
			if(flag){
				msg = "Comment deleted Successfully";
			}
		} 
		catch(Exception ex){
			msg ="Error deleting comment";
		}
		model.addAttribute("msg", msg);
		return "home";
	}
}
