package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.service.ProductListService;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Saddam Hussein
 *
 */

@ManagedBean
public class ProductListController {

	private List <Product> prd;

	public ProductListController() {
		String catId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");
		if(catId!=null){
		Long categoryId = Long.parseLong(catId);
		ProductListService pls = new ProductListService();
		prd = pls.getProductByCategory(categoryId);
		}else{
			ProductListService pls = new ProductListService();
			prd = pls.getAllProduct();
		}

	}

	public List<Product> getPrd() {
		return prd;
	}

	public void setPrd(List<Product> prd) {
		this.prd = prd;
	}
	
	
	
	
	
}
