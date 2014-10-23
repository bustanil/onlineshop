package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.service.LoginService;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginController {
	
	private String email;
	private String password;
	
	public void checkUser() {
		
		LoginService loginService = new LoginService();
		loginService.checkLogin(email, password);
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
