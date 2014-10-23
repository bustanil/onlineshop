package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.ShoppingCart;
import id.co.skyforce.shop.service.ShoppingCartService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
@SessionScoped
public class ShoppingCartController {

	private ShoppingCart cart = new ShoppingCart();
	
	public String countItem() {
		ShoppingCartService cartService = new ShoppingCartService();
		return String.valueOf(cartService.incrementQuantity(cart));
	}
	
	public ShoppingCart getCart() {
		return cart;
	}
	
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

}
