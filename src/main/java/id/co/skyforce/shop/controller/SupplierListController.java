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
	private List <Supplier> supplier;
	
	public SupplierListController(){
		String catId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");
		if(catId!=null){
			Long categoryId = Long.parseLong(catId);
			SupplierListService slc =  new SupplierListService();
			supplier = slc.getSupplierByCategory(categoryId);
		}else{
			SupplierListService slc = new SupplierListService();
			supplier = slc.getAllSupplier();
		}
	}

	/**
	 * @return the supplier
	 */
	public List<Supplier> getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(List<Supplier> supplier) {
		this.supplier = supplier;
	}
	
}
