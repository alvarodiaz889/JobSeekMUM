package mum.cs472.magd.entity;

import java.io.Serializable;
/**
 * @author Daniyal Saeed
 * @version 1.0.0
 * @since 2017
 * <h1>Maharishi University of Management Job Seek Application </h1>
 * <h2>Login Pojo </h2>
 */
public final class Login implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	
	public Login(){}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
