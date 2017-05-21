package mum.cs472.magd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mum.cs472.magd.entity.User;
import mum.cs472.magd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

	@Autowired
	UserService userService;
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
		
		return url;
	}
}
