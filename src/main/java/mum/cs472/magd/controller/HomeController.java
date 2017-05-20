package mum.cs472.magd.controller;



import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class HomeController {


	
	@RequestMapping(value="/Home")
	public String viewHome(HttpServletRequest request, Model model){
		return "home";
	}
}
