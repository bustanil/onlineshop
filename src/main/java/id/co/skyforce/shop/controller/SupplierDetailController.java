package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.service.ProductDetailService;
import id.co.skyforce.shop.service.SupplierDetailService;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SupplierDetailController {

	private Supplier supplier;
		
	public SupplierDetailController(){
		SupplierDetailService sds = new SupplierDetailService();
		supplier = sds.getDetailSupplier();
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
}
