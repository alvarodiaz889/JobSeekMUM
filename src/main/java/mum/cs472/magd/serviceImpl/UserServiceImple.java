package mum.cs472.magd.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		String query = "SELECT EMAIL,PASSWORD FROM USERS WHERE EMAIL=? AND PASSWORD =?";
		userList=dao.getData(query, new Object[]{user.getEmail(),user.getPassword()});
		if(null!=userList && userList.size()>0){flag = true;}
		
		return flag;
	}
	@Override
	public boolean insertUser(User user) {
		boolean flag = false;
		String query ="INSERT INTO USERS(FULLNAME,GENDER,BIRTHYEAR,STATE,STREET,CITY,EMAIL,ZIPCODE,PASSWORD,DATECREATED,DATEUPDATED)  "+
					  "VALUES(?,?,?,?,?,?,?,?,?,CURDATE(),CURDATE()) " ;
		
		
		Object[] params =
	new Object[]{user.getFullName(),Integer.parseInt(user.getGender()),Integer.parseInt(user.getBirthYear()),user.getState(),user.getStreet(),
				user.getCity(),user.getEmail(),Integer.parseInt(user.getZipCode()),user.getPassword()};
		flag = dao.update(query, params);  
		
		return flag;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public String getUserId(User user) {
		String userId = "";
		String query ="SELECT USERID FROM USERS WHERE EMAIL=? AND PASSWORD =? ";
		List userIds  = dao.getData(query,new Object[]{user.getEmail(),user.getPassword()});
		if(userIds!=null && userIds.size()>0){
			Map m = (HashMap)userIds.get(0);
			if(m.containsKey("USERID") && m.get("USERID")!=null){
				userId = m.get("USERID").toString();
			}
		}
		return userId;
	}
}
