package mum.cs472.magd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.cs472.magd.entity.User;
import mum.cs472.magd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	@SuppressWarnings("unused")
	@RequestMapping(value="signUp")
	public String viewPost(HttpServletRequest request,Model model,User user){
		
		String url="";
		boolean flag = false;
		try{
		flag = userService.insertUser(user);
		String userId = userService.getUserId(user);
		if(flag){
			url ="home";
			HttpSession session = request.getSession(false);
			session = request.getSession(true);
			session.setAttribute("user", user.getEmail());
			session.setAttribute("userId", userId);
			
		}
		else {
			url = "home";
			model.addAttribute("msg", "Issue occured while inserting the user");
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return "home";
	}
	
	
	@RequestMapping(value="getUsers")
	public void getUSers(HttpServletRequest request,HttpServletResponse response, Model model) throws IOException{
		
		
		List<User> users = userService.listUsers();
		String json =  "" ; 
		json =new Gson().toJson(users);
		response.getWriter().write("{ \"data\":"   + json + " }"); 
	}
	
	@RequestMapping(value ="viewUserProfile")
	public String getUserProfile(HttpServletRequest request, Model model, @RequestParam("userId") String userId){
		
		List<User> userList = new ArrayList<>();
		try{
		userList=userService.userProfile(userId);
		if(userList.size()>0 && null!= userList){
			model.addAttribute("userList", userList);
		}
		}catch(Exception ex){
			model.addAttribute("msg", "Something went wrong ! :( :( ");
		}
		return "userProfile";
	}
}
