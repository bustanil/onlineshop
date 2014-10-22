package id.co.skyforce.shop.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "home_phone", length = 50, nullable = false)
	private String homePhone;
	
	@Column(name = "mobile_phone", length = 50, nullable = false)
	private String mobilePhone;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "last_update", nullable = false)
	private Date lastUpdate;
	
	public Contact(){
		
	}
	
	public Contact(Long id, String name, String homePhone,
			String mobilePhone, String email, Date lastUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.lastUpdate = lastUpdate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", homePhone="
				+ homePhone + ", mobilePhone=" + mobilePhone + ", email="
				+ email + ", lastUpdate=" + lastUpdate + "]";
	}

	
	
	
	

	
	
}
