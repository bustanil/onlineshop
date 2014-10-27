package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.model.Product;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
@SessionScoped
public class ShoppingCartController {
	
	private Integer totalItem = 0;
	
	private Customer customer;
	
	private List<Product> products;
	
	public void incrementTotalItem() {
		
		totalItem += 1;
		
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			externalContext.redirect("list.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
