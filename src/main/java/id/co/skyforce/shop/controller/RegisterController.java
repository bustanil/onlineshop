package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Address;
import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.model.CustomerStatus;
import id.co.skyforce.shop.service.RegisterService;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
public class RegisterController {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String mobileNo;
	private String homePhone;
	private String salutation;
	private Character gender;
	private String street;
	private String city;
	private String postalCode;
	private Long customerId;
	private Long addressId;

	private Customer customer = new Customer();

	public void simpanCustomer(){
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setBirthDate(birthDate);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setMobileNo(mobileNo);
		customer.setHomePhone(homePhone);
		customer.setSalutation(salutation);
		customer.setGender(gender);
		customer.setStatus(CustomerStatus.ACTIVE);

		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setPostalCode(postalCode);

		customer.setAddress(address);

		newCustomer(customer);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void newCustomer(Customer customer) {
		RegisterService regService = new RegisterService();
		regService.register(customer);
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

}
