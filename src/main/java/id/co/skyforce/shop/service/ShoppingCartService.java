package id.co.skyforce.shop.service;

import id.co.skyforce.shop.controller.ShoppingCartController;
import id.co.skyforce.shop.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 
 * @author Irwansyah Hazniel
 *
 */

public class ShoppingCartService {
	
	public BigDecimal totalAmountService(Map<Product, Long> productsAndQuantity) {
		
//		ShoppingCartController cartController = new ShoppingCartController();
		
//		Map<Product, BigDecimal> productsAndPrice = new HashMap<>();
		
		BigDecimal totalAmount = null;
		
		for (Entry<Product, Long> e : productsAndQuantity.entrySet()) {
//			productsAndPrice.put(e.getKey(), 
//					e.getKey().getPrice().multiply(BigDecimal.valueOf(e.getValue())));
			totalAmount = totalAmount.add(e.getKey().getPrice().multiply(BigDecimal.valueOf(e.getValue()))); 
		}
		
//		cartController.setProductsAndPrice(productsAndPrice);
		
		return totalAmount;
	}
	
}
