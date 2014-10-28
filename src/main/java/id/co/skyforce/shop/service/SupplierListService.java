package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.util.HibernateUtil;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Wirahman
 *
 */

public class SupplierListService {

	public List getSupplierByCategory(Long categoryId){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("from Supplier s where s.category.id=:cat.Id");
		query.setLong("catId", categoryId);
		List <Supplier> sup = query.list();
		
		trx.commit();
		session.close();
		return sup;
		
	}
	public SupplierListService(){
		
	}
	
	public List getAllSupplier(){
		List <Supplier> supp;
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		supp = session.createQuery("from Supplier").list();
		
		trx.commit();
		session.close();
		return supp;
	}
	
}
