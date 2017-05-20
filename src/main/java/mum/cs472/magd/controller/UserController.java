package mum.cs472.magd.controller;

import javax.servlet.http.HttpServletRequest;

import mum.cs472.magd.entity.User;
import mum.cs472.magd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@RequestMapping(value="signUp")
	public String viewPost(HttpServletRequest request,Model model,
			@RequestParam("fullName") String fullName,
			@RequestParam("password")String password,
			@RequestParam("city") String city,
			@RequestParam("zipCode") String zipCode,
			@RequestParam("gender") String gender,
			@RequestParam("email") String email,
			@RequestParam("state") String state,
			@RequestParam("birthYear") int birthYear){
		
		
		int genderValue = 0;
		if(gender.equals("f")) genderValue = 1;
		else genderValue = 0;
		User user = new User();
		String url="";
		user.setFullName(fullName);
		user.setGender(genderValue);
		user.setCity(city);
		user.setBirthYear(birthYear);
		user.setState(state);
		user.setEmail(email);
		user.setPassword(password);
		user.setZipCode(Integer.parseInt(zipCode));
		boolean flag = false;
		flag = userService.insertUser(user);
		if(flag){url ="post";
		 //set the session
		}
		else {
			url = "home";
			model.addAttribute("msg", "Issue occured while inserting the user");
		}
		return url;
	}
}
