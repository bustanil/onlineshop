package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.ShoppingCart;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ShoppingCartController {

	private ShoppingCart cart;

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

}
