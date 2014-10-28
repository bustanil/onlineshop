package id.co.skyforce.shop.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.service.ProductListService;
import id.co.skyforce.shop.service.ProductService;
import id.co.skyforce.shop.service.SupplierListService;
import id.co.skyforce.shop.service.SupplierService;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Wirahman
 *
 */
@ManagedBean
public class SupplierController {
	
	private String name;
	private Long supplierId;
	
	private List<Supplier> suppliers;
	private String keyword;

	public SupplierController(){
		
		String idSupplier = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("supplier_id");
		
		SupplierService suppService = new SupplierService();
		
		if(idSupplier != null){
			supplierId = Long.valueOf(idSupplier);
			
			Supplier supplier = suppService.getSupplier(supplierId);
			
			name = supplier.getName();
			
		}
	}

	public String searchByName(){
		SupplierService suppService = new SupplierService();
		
		this.suppliers = suppService.searchByNameService(this.keyword);
		
		SupplierListController suppListController = new SupplierListController();
		suppListController.setSupp(null);
		
		return "list";
	}

	public String TambahSup(){	

		SupplierService suppService = new SupplierService();
		
		Supplier supplier = new Supplier();
		supplier.setName(name);
		
		//Mengubah supplierId jika tidak ada isinya(null) tetapi akan memasukkan supplierId yang baru jika supplierId tersebut belum ada
		
		supplier.setId(this.supplierId);
		
		suppService.saveService(supplier);
		
		return "listsupplier";
		
	}
	

	public void DeleteSup(){

		String SupplierId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("idDelete");
		this.supplierId = Long.valueOf(SupplierId);
		
		SupplierService suppService = new SupplierService();
		suppService.deleteService(this.supplierId);
		
		//update object list setelah dihapus
		SupplierListService suppListService = new SupplierListService();
		List<Supplier> suppliers = suppListService.getAllSupplier();
		
		SupplierListController suppListController = new SupplierListController();
		suppListController.setSupp(suppliers);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			externalContext.redirect("listsupplier.xhtml");
		} catch (IOException e){
			e.printStackTrace();
		}
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	

	
}
