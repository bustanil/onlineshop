package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.service.LoginService;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Saddam Hussein
 *
 */

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

	public static String AUTH_KEY = "app.user.name";

	private String email;
	private String password;
	String url;
	Customer cust = new Customer();

	public LoginController(){
		String IdCustomer=  FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("idcustomer");
		if (IdCustomer!=null){
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			try {

				externalContext.redirect("/product/list.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String login(){
		LoginService ls = new LoginService();
		boolean result = ls.login(email, password);
		if (result){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, email);
			cust = new Customer();
			cust = ls.getCustomer();
			
			ShoppingCartController cartController = new ShoppingCartController();
			cartController.setCustomer(cust);
			
			return "/product/list";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage
					(FacesMessage.SEVERITY_WARN,
							"Invalid Email Or Password! Please Try Again",
							"Please Try Again!"));
			return "login";
		}
	}

	public String logout(){
		LoginService ls = new LoginService();
		ls.logout();
		cust = null;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_KEY);
		return "/product/list"; 
	}

	public boolean isLoggedIn(){
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(AUTH_KEY) != null;

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

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

}
