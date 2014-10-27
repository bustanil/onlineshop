package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.service.ProductDetailService;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
@SessionScoped
public class ProductDetailController implements Serializable {
	
	private Long productId;
	private Product product;
//	private Integer totalItem = 0;
	
	@ManagedProperty(value="#{shoppingCartController}")
	private ShoppingCartController cartController;

	public ProductDetailController() {
		
		productId = Long.parseLong(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id"));
		
		ProductDetailService detailService = new ProductDetailService();
		product = detailService.getDetailProduct(productId);
		
//		cartController.setProductId(productId);
//		cartController.addProduct(product);
		
	}
	
	public void tambahProduct(AjaxBehaviorEvent a) {
		
		cartController.addProduct(product);
		cartController.incrementTotalItem();
	
	}
	
//	public void incrementTotalItem() {
//		
//		totalItem += 1;
//		
//		ProductDetailService detailService = new ProductDetailService();
//		product = detailService.getDetailProduct(productId);
//		
//		cartController.addProduct(product);
//		
//	}

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

//	public Integer getTotalItem() {
//		return totalItem;
//	}
//
//	public void setTotalItem(Integer totalItem) {
//		this.totalItem = totalItem;
//	}

	public ShoppingCartController getCartController() {
		return cartController;
	}

	public void setCartController(ShoppingCartController cartController) {
		this.cartController = cartController;
	}
	
}