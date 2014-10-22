package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.util.HibernateUtil;
import id.co.skyforce.shop.model.Address;
import id.co.skyforce.shop.model.Customer;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerController {
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

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public void Register(){
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Customer cus = new Customer();
		
		cus.setId(customerId);
		
		cus.setFirstName(firstName);
		cus.setLastName(lastName);
		cus.setEmail(email);
		cus.setHomePhone(homePhone);
		cus.setMobileNo(mobileNo);
		cus.setPassword(password);
		cus.setBirthDate(birthDate);
		cus.setGender(gender);
		cus.setSalutation(salutation);
		
		Address ad = new Address();
		ad.setId(addressId);
		ad.setStreet(street);
		ad.setCity(city);
		ad.setPostalCode(postalCode);
		cus.setAddress(ad);
	
		session.save(cus);
		trx.commit();
		session.close();
	}
		
	public void Login(){
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
	
		Customer cus = new Customer();
		cus = (Customer) session.createQuery("from Customer where email").uniqueResult();
		cus = (Customer) session.createQuery("from Customer where password").uniqueResult();
		trx.commit();
		session.close();
	
	}
	
	
	/*@ManagedBean
public class CustomerListController {
	
	private List<Customer> customers;
	
	

	public CustomerListController() {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		customers = session.createQuery("from Customer where email").uniqueResult();
		
		trx.commit();
		session.close();
		
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
*/
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
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	
}
