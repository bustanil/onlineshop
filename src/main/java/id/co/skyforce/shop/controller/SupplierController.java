package id.co.skyforce.shop.controller;

import java.io.IOException;
import java.util.Set;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.service.ProductListService;
import id.co.skyforce.shop.util.HibernateUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * 
 * @author Wirahman
 *
 */
@ManagedBean
public class SupplierController {
	private Long supplierId;
	private String name;
	private Long category_id;
		
	public SupplierController(){
		String idSupplier = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");
		
		if(idSupplier != null){
			supplierId = Long.valueOf(idSupplier);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Supplier s = (Supplier) session.get(Supplier.class, supplierId);
			trx.commit();
			session.close();
			
			name = s.getName();
			category_id = s.getCategory().getId();
		}
	}
	public void TambahSup(){	
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Category cat = (Category) session.get(Category.class, category_id);
		
		Supplier s = new Supplier();
		s.setId(supplierId);
		s.setName(name);
		s.setCategories((Set<Category>) cat);
		session.saveOrUpdate(s);
		trx.commit();
		session.close();
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try{
			externalContext.redirect("list_Supplier.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteSup(){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Supplier s = (Supplier) session.get(Supplier.class, supplierId);
		session.delete(s);
		trx.commit();
		session.close();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("list_supplier.xhtml");
		} catch (IOException e) {
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
	 * @return the category_id
	 */
	public Long getCategory_id() {
		return category_id;
	}
	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	
}
