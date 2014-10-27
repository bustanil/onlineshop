package id.co.skyforce.shop.service;

/**
 * 
 * @author Saddam Hussein
 *
 */
import id.co.skyforce.shop.model.Order;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TransactioHistoryService {
	public List getAllOrder(Long idCustomer){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("from Order o where o.customer.id=:idCustomer");
		query.setLong("idCustomer", idCustomer);
		List <Order> orderList =  query.list();
		
		trx.commit();
		session.close();
		return orderList;
	}

}
