package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.service.LoginService;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginController {

	private String email;
	private String password;
	
	private Customer customer = new Customer();
	
	public void Login(){
		customer.getEmail();
		customer.getPassword();
		
		LoginService loginSer = new LoginService();
		loginSer.login(customer); 
		customer = loginSer.login(customer);
	}
	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
