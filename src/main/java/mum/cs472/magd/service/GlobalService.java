package mum.cs472.magd.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public interface GlobalService {
	public boolean isUserSessionExist(HttpServletRequest request);
}
