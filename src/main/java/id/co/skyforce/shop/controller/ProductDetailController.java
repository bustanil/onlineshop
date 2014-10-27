package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.service.ProductDetailService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
public class ProductDetailController {
	
	private Long productId;
	private Product product;
	private Integer totalItem = 0;

	public ProductDetailController() {
		
		productId = Long.parseLong(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id"));
		
		ProductDetailService detailService = new ProductDetailService();
		product = detailService.getDetailProduct(productId);
		
	}
	
	public void incrementTotalItem() {
		
		totalItem += 1;
		
		ShoppingCartController cartController = new ShoppingCartController();
		
//		ProductDetailService detailService = new ProductDetailService();
//		product = detailService.getDetailProduct(productId);
		
		cartController.setProduct(product);
		
		cartController.addProduct();
		
		// check apakah product sudah ada di map
//		long incrementQuantity = productsAndQuantity.containsKey(product) ? productsAndQuantity.get(product) : 0;
		
		// add product to to map product
//		productsAndQuantity.put(product, incrementQuantity + 1);
		
		// tidak perlu di-direct ke page lain, karena sudah menggunakan AJAX
		// sehingga perubahan langsung diterapkan
		
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	
}