package id.co.skyforce.shop.service;

import id.co.skyforce.shop.controller.LoginController;
import id.co.skyforce.shop.controller.ShoppingCartController;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.model.ShoppingCart;
import id.co.skyforce.shop.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * 
 * @author Irwansyah Hazniel
 *
 */

public class ShoppingCartService {
	
	public BigDecimal totalAmountService(Map<Product, Long> productsAndQuantity) {
		
		BigDecimal totalAmount = new BigDecimal(0);
		
		for (Entry<Product, Long> e : productsAndQuantity.entrySet()) {
			
			totalAmount = totalAmount.add(e.getKey().getPrice().multiply(BigDecimal.valueOf(e.getValue()))); 
			
		}
		
		return totalAmount;
	}
	
	public ShoppingCart deleteService(Long cartId) {
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		ShoppingCart sc = (ShoppingCart) session.get(ShoppingCart.class, cartId);
		
		session.delete(sc);
		
		transaction.commit();
		session.close();
		
		return sc;

	}
	
}
