package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.util.HibernateUtil;

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
	
	
	public List<Product> searchByNameService(String keyword) {
		
		Session session = HibernateUtil.openSession();
		
		Query query = session.createQuery("FROM Product p WHERE p.name LIKE :productName");
		query.setString("productName", "%" + keyword + "%");
		
		List<Product> products = query.list();
		
		session.close();
		
		return products;
		
	}
	
	public Product saveService(Product product) {
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(product);
		
		transaction.commit();
		session.close();
		
		return product;
		
	}
	
	public Product deleteService(Long productId) {
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = (Product) session.get(Product.class, productId);
		
		session.delete(product);
		
		transaction.commit();
		session.close();
		
		return product;
		
	}
	
	public Product getProduct(Long productId) {
		
		Session session = HibernateUtil.openSession();
		
		Product product = (Product) session.get(Product.class, productId);
		
		// getId assosiation dengan FetchType.LAZY
		product.getCategory().getId();
		product.getSupplier().getId();
		
		session.close();
		
		return product;
		
	}
	
	public Category getCategory(Long categoryId) {
		
		Session session = HibernateUtil.openSession();
		
		Category category = (Category) session.get(Category.class, categoryId);
		
		session.close();
		
		return category;
		
	}
	
	public Supplier getSupplier(Long supplierId) {
		
		Session session = HibernateUtil.openSession();

		Supplier supplier = (Supplier) session.get(Supplier.class, supplierId);

		session.close();

		return supplier;
		
	}
	
	public List<Category> getAllCategories() {
		
		Session session = HibernateUtil.openSession();
		
		List<Category> categories = session.createQuery("FROM Category").list();
		
		session.close();
		
		return categories;
		
	}
	
	public List<Supplier> getAllSuppliers() {
		
		Session session = HibernateUtil.openSession();
		
		List<Supplier> suppliers = session.createQuery("FROM Supplier").list();
		
		session.close();
		
		return suppliers;
		
	}
	
}
