package id.co.skyforce.shop.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name = "salutation", length = 10, nullable = false)
	private String salutation;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status" , length = 10, nullable = false)
	private CustomerStatus status;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "birth_date", length = 50, nullable = false)
	private Date birthDate;
	
	@Column(name = "mobile_phone", length = 50, nullable = false)
	private String mobileNo;
	
	@Column(name = "home_phone", length = 50, nullable = false)
	private String homePhone;
	
	@Column(name = "gender", length = 1, nullable = false)
	private Character gender;
	
	@ManyToOne(cascade = CascadeType.ALL) //one to one
	@JoinColumn(name = "address_id", unique = true)
	private Address address;
	
	@OneToMany
	@JoinColumn(name = "customer_id")
	private Set<Order> orders;
	
	@OneToMany
	@JoinColumn(name = "customer_id")
	private Set<ShoppingCart> carts;

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

	public CustomerStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerStatus active) {
		this.status = active;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
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

	public Set<ShoppingCart> getCarts() {
		return carts;
	}

	public void setCarts(Set<ShoppingCart> carts) {
		this.carts = carts;
	}
	
}
