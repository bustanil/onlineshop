package id.co.skyforce.shop.service;

public class ShoppingCartService {
	
	public Integer incrementQuantity(int item) {
		item += 1;
		return item;
	}
	
}
