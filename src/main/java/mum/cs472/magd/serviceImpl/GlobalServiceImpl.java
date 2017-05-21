package mum.cs472.magd.serviceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mum.cs472.magd.service.GlobalService;

import org.springframework.stereotype.Controller;

@Controller
public class GlobalServiceImpl implements GlobalService {

	@SuppressWarnings("finally")
	@Override
	public boolean isUserSessionExist(HttpServletRequest request) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			HttpSession session = request.getSession(false);
			if(session!=null && session.getAttribute("user")!=null){
				flag = true;
			}
		}catch(Exception ex){
			flag = false;
			ex.printStackTrace();
		}finally{
			return flag;
		}
	}

}

