package id.co.skyforce.shop.service;

import id.co.skyforce.shop.controller.LoginController;
import id.co.skyforce.shop.controller.ShoppingCartController;
import id.co.skyforce.shop.model.Product;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


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
	
}
