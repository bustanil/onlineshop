package id.co.skyforce.shop.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.model.Supplier;
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
	private Long categoryId;
	private Long supplierId;
	
	private List<Supplier> suppliers;
	private List<Category> categories;
	private String keyword;

	public SupplierController(){
		String idSupplier = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");
		SupplierService suppService = new SupplierService();
		
		if(idSupplier != null){
			supplierId = Long.valueOf(idSupplier);
			
			Supplier supplier = suppService.getSupplier(supplierId);
			
			name = supplier.getName();
			categoryId = supplier.getCategory().getId();
			
		}
	}

	public String searchByName(){
		SupplierService suppService = new SupplierService();
		
		this.suppliers = suppService.searchByNameService(this.keyword);
		
		SupplierListController suppListController = new SupplierListController();
		suppListController.setSupplier(null);
		
		return "list";
	}

	public String TambahSup(){	

		SupplierService suppService = new SupplierService();
		
		Category category = suppService.getCategory(this.categoryId);
		Supplier supplier = new Supplier();
		supplier.setName(name);
		
		//Mengubah supplierId jika tidak ada isinya(null) tetapi akan memasukkan supplierId yang baru jika supplierId tersebut belum ada
		
		supplier.setId(this.supplierId);
		
		supplier.setCategory(category);
		
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
		suppListController.setSupplier(suppliers);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			externalContext.redirect("listsupplier.xhtml");
		} catch (IOException e){
			e.printStackTrace();
		}
		}

	/**
	 * @return the supplierId
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the suppliers
	 */
	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	/**
	 * @param suppliers the suppliers to set
	 */
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

	
}
