package mum.cs472.magd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mum.cs472.magd.entity.Post;
import mum.cs472.magd.entity.User;
import mum.cs472.magd.service.GlobalService;
import mum.cs472.magd.service.PostService;
import mum.cs472.magd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class SessionController {
	@Autowired
	UserService adminSvc;
	@Autowired
	GlobalService glbSrv;
	@Autowired
	private PostService postService;
	public static String errMsg = "";

	
	@SuppressWarnings("finally")
	@RequestMapping(value="post")
	public String verifyAdminLogin(HttpServletRequest request, Model model,User user){
		String message = "";
		String url = "home";
		try{
			if(glbSrv.isUserSessionExist(request)){
				url = "home";
			}
			if(user.getEmail()!=null && !user.getEmail().isEmpty() && user.getPassword()!=null && !user.getPassword().isEmpty()){
				boolean flag = adminSvc.isValid(user);
				String userId = adminSvc.getUserId(user);
				if(flag){
					HttpSession session = request.getSession(false);
					session = request.getSession(true);
					session.setAttribute("user", user);
					session.setAttribute("userId", userId);
					session.setAttribute("isAdmin", "admin");
					List<Post> posts = new ArrayList<>();
					posts = postService.getPosts();
					model.addAttribute("posts", posts);
					url = "home";
				}else{
					model.addAttribute("msg", "Invalid parameters");
					
					url = "home";
				}
			}else{
				model.addAttribute("msg", "Invalid parameters");
				url = "home";
			}
		}catch(Exception ex){
			message = "Something went wrong ;(";
			model.addAttribute("msg",message);
			ex.printStackTrace();
		}finally{
			return "home";
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="signOut")
	public String logOutUser(HttpServletRequest request, Model model){
		String message = "",url = "home";
		try{
			if(glbSrv.isUserSessionExist(request)){
				HttpSession session = request.getSession(false);
				session.removeAttribute("user");
				session.removeAttribute("isAdmin");
				session.invalidate();
				errMsg = "User signedout successfully";
				model.addAttribute("msg", errMsg);
				url = "home";
			}
		}catch(Exception ex){
			message = "Something went wrong ;(";
			model.addAttribute("message",message);
			ex.printStackTrace();
		}finally{
			return url;
		}
	}
}

