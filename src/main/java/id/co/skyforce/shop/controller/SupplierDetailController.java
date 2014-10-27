package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.service.SupplierDetailService;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
/**
 * 
 * @author Wirahman
 *
 */
@ManagedBean

public class SupplierDetailController {

	private Long supplierId;
	private Supplier supplier;
		
	public SupplierDetailController(){
		supplierId = Long.parseLong(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id"));
		
		SupplierDetailService detailService = new SupplierDetailService();
		supplier = detailService.getDetailSupplier(supplierId);
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
