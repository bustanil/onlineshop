package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.ShoppingCart;

public class ShoppingCartService {
	
	public Integer incrementQuantity(ShoppingCart cart) {
		ShoppingCart keranjang = new ShoppingCart();
		keranjang = cart;
		keranjang.setCountItem(keranjang.getCountItem()+1);
		System.out.println("keranjang.getCountItem() = " + keranjang.getCountItem());
		return keranjang.getCountItem();
	}
	
}
