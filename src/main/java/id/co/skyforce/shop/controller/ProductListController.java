package id.co.skyforce.shop.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.shop.service.ProductListService;
import id.co.skyforce.shop.service.ProductService;
import id.co.skyforce.shop.util.HibernateUtil;
import id.co.skyforce.shop.model.*;

@ManagedBean
public class ProductListController {

	private List <Product> prd;

	public ProductListController() {
		String catId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");
		Long categoryId = Long.parseLong(catId);
		ProductListService pls = new ProductListService();
		pls.getProductByCategory(categoryId);
	}

	public List<Product> getPrd() {
		return prd;
	}

	public void setPrd(List<Product> prd) {
		this.prd = prd;
	}
}
