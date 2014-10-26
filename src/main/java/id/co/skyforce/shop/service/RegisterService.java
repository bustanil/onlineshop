package id.co.skyforce.shop.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.util.HibernateUtil;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

public class RegisterService {
	
	public void register(Customer customer) {
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		session.save(customer);
		
		trx.commit();
		session.close();
		
	}
	
}
