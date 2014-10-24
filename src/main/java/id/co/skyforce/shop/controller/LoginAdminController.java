package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.service.LoginService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class LoginAdminController {
	private String email;
	private String password;
	String url;
	Customer cust = new Customer();
	
	public String login(){
		LoginService ls = new LoginService();
		boolean result = ls.login(email, password);
		if (result){
			HttpSession session = (HttpSession) FacesContext.
			          getCurrentInstance().
			          getExternalContext().
			          getSession(false);
			cust = new Customer();
			cust = ls.getCustomer();
            session.setAttribute("lastName", cust.getLastName());
 
            return "/admin/list";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "login";
		}
	}
	
	public boolean isLoggedIn(){
		if(cust.getFirstName()!=null){
			return true;	
		}
		return false;
		
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