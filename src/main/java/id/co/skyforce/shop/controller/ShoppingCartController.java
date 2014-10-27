package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.service.ShoppingCartService;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
@SessionScoped
public class ShoppingCartController implements Serializable {
	
	private Integer totalItem = 0;
	private Long productId;
	private BigDecimal totalAmount;
	
	// pass dari loginController
	private Customer customer;
	
	private Product product;
	private Map<Product, Long> productsAndQuantity = new HashMap<>();
	private Map<Product, BigDecimal> productsAndPrice  = new HashMap<>();
	
	public void incrementTotalItem() {
		
		totalItem += 1;
		
	}
	
	public Set<Entry<Product, Long>> getItems(){
		return productsAndQuantity.entrySet();
	}
	
	public void addProduct(Product product) {
		
		// check apakah product sudah ada di map
		long incrementQuantity = productsAndQuantity.containsKey(product) ? productsAndQuantity.get(product) : 0;
		
		// add product to to map product
		productsAndQuantity.put(product, incrementQuantity + 1);
		
	}
	
	public String calculateTotalAmount() {
		
		ShoppingCartService cartService = new ShoppingCartService();
		totalAmount = cartService.totalAmountService(productsAndQuantity);
		
		return "checkout";
		
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Map<Product, Long> getProductsAndQuantity() {
		return productsAndQuantity;
	}

	public void setProductsAndQuantity(Map<Product, Long> productsAndQuantity) {
		this.productsAndQuantity = productsAndQuantity;
	}

	public Map<Product, BigDecimal> getProductsAndPrice() {
		return productsAndPrice;
	}

	public void setProductsAndPrice(Map<Product, BigDecimal> productsAndPrice) {
		this.productsAndPrice = productsAndPrice;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
