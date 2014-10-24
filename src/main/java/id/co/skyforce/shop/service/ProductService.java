package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

public class ProductService {
	
	
	public void saveService(Product product) {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		session.saveOrUpdate(product);
		
		trx.commit();
		session.close();
	}
	
}
