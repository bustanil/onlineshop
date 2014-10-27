package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.service.ProductDetailService;

import javax.faces.bean.ManagedBean;
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

	public ProductDetailController() {
		
		productId = Long.parseLong(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id"));
		
		ProductDetailService detailService = new ProductDetailService();
		product = detailService.getDetailProduct(productId);
		
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

}