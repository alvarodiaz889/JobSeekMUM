package mum.cs472.magd.service;

import mum.cs472.magd.entity.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	public boolean isValid(User user);
	public boolean insertUser(User user);
	public String getUserId(User user);
	public List<User> listUsers();
}
