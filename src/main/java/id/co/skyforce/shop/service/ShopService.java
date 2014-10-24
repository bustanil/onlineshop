package id.co.skyforce.shop.service;

import java.util.List;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Sandy Septiandhy
 *
 */

public class ShopService {
	
	public List getAllCategory(){
		List<Category> category;
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		category = session.createQuery("from Category").list();
		
		trx.commit();
		session.close();
		
		return category;
			
	}
}
