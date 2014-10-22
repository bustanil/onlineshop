package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.util.HibernateUtil;

import java.util.List;

<<<<<<< HEAD
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductListService {

	public List getProductByCategory(Long categoryId){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("from Product p where p.category_id=:catId");
		query.setLong("catId", categoryId);
		List <Product> prd =  query.list();
		trx.commit();
		session.close();
		return prd;
	}
	public ProductListService(){
		
	}
=======
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductListService {

	public List getProductByCategory(Long categoryId){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("from Product p where p.category.id=:catId");
		query.setLong("catId", categoryId);
		List <Product> prd =  query.list();
		
		trx.commit();
		session.close();
		return prd;
	}
	public ProductListService(){
		
	}
	
	public List getAllProduct(){
		List <Product> prd;
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		prd = session.createQuery("from Product").list();
		
		for (Product pro : prd) {
			Hibernate.initialize(pro.getCategory().getId());
			Hibernate.initialize(pro.getSupplier()); //untuk manggil lazy fetch type
		}
		trx.commit();
		session.close();
		return prd;
	}

>>>>>>> branch 'master' of https://github.com/bustanil/onlineshop.git
}
