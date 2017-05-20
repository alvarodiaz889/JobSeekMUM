package mum.cs472.magd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.cs472.magd.entity.Login;
import mum.cs472.magd.service.LoginService;

@Controller
public class LoginController{
	
	@Autowired 
	private LoginService loginService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/login")
	public String loginUser(HttpServletRequest request,Model model,Login login){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		login.setUserName(userName);
		login.setPassword(password);
		List<Login> loginList = new ArrayList<>(); 
		loginList = loginService.getLoginDetails(login);
		model.addAttribute("login", loginList);
		return "login";
	}
}