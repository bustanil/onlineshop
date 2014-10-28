package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.service.ProductListService;
import id.co.skyforce.shop.service.SupplierListService;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Wirahman
 *
 */

@ManagedBean
public class SupplierListController {

	private List <Supplier> supp;
	
	public SupplierListController(){
		String catId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");
		if(catId!=null){
			Long categoryId = Long.parseLong(catId);
			SupplierListService sls = new SupplierListService();
			supp = sls.getSupplierByCategory(categoryId);
		}else{
			SupplierListService sls = new SupplierListService();
			supp = sls.getAllSupplier();
		}
	}

	public List<Supplier> getSupp() {
		return supp;
	}

	public void setSupp(List<Supplier> supp) {
		this.supp = supp;
	}

	
}
