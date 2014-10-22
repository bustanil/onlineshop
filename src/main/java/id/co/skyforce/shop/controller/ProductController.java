package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.util.HibernateUtil;
import id.co.skyforce.shop.model.*;


import java.io.IOException;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name="pc")
public class ProductController {

	private Long productId;
	private String name;
	private BigDecimal price;
	private Integer stock;
	private String description;
	private Long categoryId;

	public ProductController() {
		String idProduct = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");

		if(idProduct != null){
			productId = Long.valueOf(idProduct);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Product p = (Product) session.get(Product.class, productId);
			trx.commit();session.close();

			name = p.getName();
			price = p.getPrice();
			stock = p.getStock();
			description = p.getDescription();

			categoryId = p.getCategory().getId();
		}
	}

	public void save(){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Category cat = (Category) session.get(Category.class, categoryId);

		Product p = new Product();
		p.setId(productId);
		p.setName(name);
		p.setPrice(price);
		p.setStock(stock);
		p.setDescription(description);
		p.setCategory(cat);
		session.saveOrUpdate(p);
		trx.commit();
		session.close();
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("list_product.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(){
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Product p = (Product) session.get(Product.class, productId);
		session.delete(p);
		trx.commit();
		session.close();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("list_product.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
