package id.co.skyforce.shop.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.shop.model.Address;
import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.util.HibernateUtil;

public class UpdateCustomerService {
	public void update(Customer customer) {

		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(customer);
		trx.commit();
		session.close();

	}
	public Customer getCustomer(long id){
		Customer c = new Customer();
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		c = (Customer) session.get(Customer.class, id);
		trx.commit();
		session.close();
		return c;
	}
}