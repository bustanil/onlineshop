package id.co.skyforce.shop.service;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.util.HibernateUtil;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

public class ProductDetailService {
	
	public Product getDetailProduct(Long productId) {

		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		Product product = (Product) session.get(Product.class, productId);

		session.save(product);
		trx.commit();

		return product;
	}
	
}
