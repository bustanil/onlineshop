package id.co.skyforce.shop.service;

import java.util.Date;

import id.co.skyforce.shop.model.Address;
import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.util.HibernateUtil;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerService {
	
	public void registerCustomer(Customer customer){
		Session session = HibernateUtil.openSession();
		Transaction trx  = session.beginTransaction();
		
		session.save(customer);
		trx.commit();
		session.close();
	}

}