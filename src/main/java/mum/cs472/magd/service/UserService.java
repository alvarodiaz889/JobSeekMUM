package mum.cs472.magd.service;

import mum.cs472.magd.entity.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	public boolean isValid(User user);
	public boolean insertUser(User user);
}
