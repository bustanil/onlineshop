package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.service.ProductDetailService;

import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
public class ProductDetailController {
	
	private Product product;

	public ProductDetailController() {
		ProductDetailService detailService = new ProductDetailService();
		product = detailService.getDetailProduct();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}