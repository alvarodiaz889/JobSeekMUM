package mum.cs472.magd.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import mum.cs472.magd.dao.GenericDao;
import mum.cs472.magd.entity.User;
import mum.cs472.magd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServiceImple implements UserService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private GenericDao dao;
	@SuppressWarnings("unchecked")
	@Override
	public boolean isValid(User user) {
		
		boolean flag = false;
		List<User> userList = new ArrayList<>();
		String query = "SELECT EMAIL,PASSWORD FROM USER WHERE EMAIL=? AND PASSWORD =?";
		userList=dao.getData(query, new Object[]{user.getEmail(),user.getPassword()});
		if(null!=userList && userList.size()>0){flag = true;}
		
		return flag;
	}
	@Override
	public boolean insertUser(User user) {
		boolean flag = false;
		String query ="INSERT INTO USER(USER_ID,FULLNAME,GENDER,BIRTHYEAR,STATE,CITY,EMAIL,PASSWORD,DATE_CREATED,DATE_UPDATED)  "+
					  "VALUES(SEQ_USER_USERID,?,?,?,?,?,?,?,SYSDATE,SYSDATE) " ;
		Object[] params = new Object[]{user.getFullName(),user.getGender(),user.getBirthYear(),user.getState(),user.getCity(),user.getEmail(),user.getEmail()};
		flag = dao.update(query, params);
		return flag;
	}
}
