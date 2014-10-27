package id.co.skyforce.shop.controller;

import java.io.IOException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;




import javax.servlet.http.HttpServletResponse;

import id.co.skyforce.shop.model.Address;
import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.model.CustomerStatus;
import id.co.skyforce.shop.service.RegisterService;
import id.co.skyforce.shop.service.UpdateCustomerService;
import id.co.skyforce.shop.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@SessionScoped
public class UpdateCustomerController {

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String mobileNo;
	private String homePhone;
	private String salutation;
	private Character gender;
	private String status;

	private String street;
	private String city;
	private String postalCode;
	private Long customerId;
	private Long addressId;
	//private S customer;
	Customer customer = new Customer();

	public UpdateCustomerController(){
		String IdCustomer=  FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("idcustomer");
//		if (IdCustomer == null){
//			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//			
//			try {
//				
//				externalContext.redirect("login.xhtml");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		customerId = Long.valueOf(IdCustomer);
		UpdateCustomerService ucs = new UpdateCustomerService();
		customer = ucs.getCustomer(customerId);

		//		LoginController lc = new LoginController();
		//		customer = lc.getCust();

		email = customer.getEmail();
		firstName = customer.getFirstName();
		lastName = customer.getLastName();
		birthDate = customer.getBirthDate();
		mobileNo = customer.getMobileNo();
		homePhone = customer.getHomePhone();
		salutation = customer.getSalutation();
		gender = customer.getGender();
		street = customer.getAddress().getStreet();
		postalCode = customer.getAddress().getPostalCode();
		city = customer.getAddress().getCity();

	}

	public String updateCustomer(){
		if(!password.equals(customer.getPassword())){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Invalid password!",
							"Please Try Again!"));
			return "update";
		}
		customer.setId(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setBirthDate(birthDate);
		customer.setStatus(CustomerStatus.ACTIVE);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setMobileNo(mobileNo);
		customer.setHomePhone(homePhone);
		customer.setSalutation(salutation);
		customer.setGender(gender);
		
		customer.getAddress().setCity(city);
		customer.getAddress().setPostalCode(postalCode);
		customer.getAddress().setStreet(street);

		UpdateCustomerService ucs = new UpdateCustomerService();
		ucs.update(customer);
		return "/product/list";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
