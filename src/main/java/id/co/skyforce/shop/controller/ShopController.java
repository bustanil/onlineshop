package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.service.ShopService;

import java.util.List;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class ShopController {

  private List<Category> allCategories;
  
	public ShopController(){
	 ShopService shopService = new ShopService();
	 allCategories = shopService.getAllCategory();
 }

	public List<Category> getAllCategories() {
		return allCategories;
	}

	public void setAllCategories(List<Category> allCategories) {
		this.allCategories = allCategories;
	}
<<<<<<< HEAD
 
 

=======
>>>>>>> branch 'master' of https://github.com/bustanil/onlineshop.git
}
