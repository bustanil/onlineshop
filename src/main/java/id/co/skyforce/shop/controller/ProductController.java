package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.service.ProductService;
import id.co.skyforce.shop.util.HibernateUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Sandy Septiandhy
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
public class ProductController {

	private Long productId;
	private String name;
	private BigDecimal price;
	private Integer stock;
	private String description;
	private Long categoryId;
	private Long supplierId;
	
	private List<Category> categories;
	private List<Supplier> suppliers;
	
	public ProductController() {
		
		String passProductId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("product_id");
//		String passCategoryId = FacesContext.getCurrentInstance()
//				.getExternalContext().getRequestParameterMap().get("category_id");
//		String passSupplierId = FacesContext.getCurrentInstance()
//				.getExternalContext().getRequestParameterMap().get("supplier_id");
		
		if (passProductId != null) {
			
			this.productId = Long.valueOf(productId);
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			
			Product product = (Product) session.get(Product.class, this.productId);
			
			// temporary change
//			System.out.println("id = " + product.getId() + ", name = " + product.getName() 
//					+ ", description = " + product.getDescription() + ", price = " + product.getPrice() + 
//					", stock = " + product.getStock());
			
			this.name = product.getName();
			this.price = product.getPrice();
			this.stock = product.getStock();
			this.description = product.getDescription();
			this.categoryId = product.getCategory().getId();
			this.supplierId = product.getSupplier().getId();
			
			categories = session.createQuery("FROM Category").list();
			suppliers = session.createQuery("FROM Supplier").list();
			
			trx.commit();
			session.close();
			
		}
		
	}
	
	public String save() {
		
		Product product = new Product();
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		Category category = (Category) session.get(Category.class, categoryId);
		Supplier supplier = (Supplier) session.get(Supplier.class, supplierId);
		
		trx.commit();
		session.close();
		
		// jika not null, otomatis update
		product.setId(productId);
		
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setDescription(description);
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		// jika not null, otomatis update
//		category.setId(this.categoryId);
		
		// jika not null, otomatis update
//		supplier.setId(this.supplierId);
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		ProductService proService = new ProductService();
		proService.saveService(product);
		

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			externalContext.redirect("listproduct");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "listproduct";
		
//		return "link kemana?";
		
	}

	public void delete() {

		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Product p = (Product) session.get(Product.class, productId);
		session.delete(p);
		trx.commit();
		session.close();
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
}
