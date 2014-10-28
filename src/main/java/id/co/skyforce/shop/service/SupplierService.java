package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Wirahman
 *
 */
public class SupplierService {

	public List<Supplier> searchByNameService(String keyword){
		
		Session session = HibernateUtil.openSession();
		
		Query query = session.createQuery("From Supplier s where s.name like :supplierName");
		query.setString("supplierName", "%" +keyword+"&");
		
		List<Supplier> supplier = query.list();
		
		session.close();
		
		return supplier;
	}

	public Supplier saveService(Supplier supplier){
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		session.saveOrUpdate(supplier);
	
		trx.commit();
		session.close();
		
		return supplier;
	}

	public Supplier deleteService(Long supplierId){
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		Supplier supplier = (Supplier) session.get(Supplier.class, supplierId);
		
		session.delete(supplier);
		
		trx.commit();
		session.close();
		
		return supplier;
	}
	
	public Supplier getSupplier(Long supplierId){
		
		Session session = HibernateUtil.openSession();
		
		Supplier supplier = (Supplier) session.get(Supplier.class, supplierId);
		
		//Mendapatkan nilai Id dengan hubungan yang bertipe LAZY
		
		session.close();
		
		return supplier;
	}
		public Category getCategory(Long categoryId) {
			
			Session session = HibernateUtil.openSession();
			
			Category category = (Category) session.get(Category.class, categoryId);
			
			session.close();
			
			return category;
			
		}
		

		public List<Category> getAllCategories() {
			
			Session session = HibernateUtil.openSession();
			
			List<Category> categories = session.createQuery("FROM Category").list();
			
			session.close();
			
			return categories;
			
		}
		


}
