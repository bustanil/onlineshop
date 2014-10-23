package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginService {
	
	public void checkLogin(String email, String password) {
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		Query query = session.createQuery("FROM Customer m WHERE m.email = :email AND m.password = :password");
		query.setString("email", email);
		query.setString("password", password);
		Customer customer = (Customer) query.uniqueResult();
		
		System.out.println(customer.getFirstName());
		System.out.println(customer.getLastName());
		System.out.println(customer.getEmail());
		System.out.println(customer.getPassword());
		
		trx.commit();
		session.close();
		
		
	}
	
}
