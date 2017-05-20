package mum.cs472.magd.controller;

import javax.servlet.http.HttpServletRequest;

import mum.cs472.magd.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentSerivce;
	
	@RequestMapping("/HomePage")
	public String myHomePage(HttpServletRequest request, Model model){
		
		
		return "home.jsp";
	}
}
