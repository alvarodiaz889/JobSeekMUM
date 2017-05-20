package mum.cs472.magd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mum.cs472.magd.entity.Login;

@Service
public interface LoginService {

	public List<Login> getLoginDetails(Login login);
}
