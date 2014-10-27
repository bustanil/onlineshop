package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Category;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.service.ProductListService;
import id.co.skyforce.shop.service.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
	private Category category;
	private Supplier supplier;
	private Long categoryId;
	private Long supplierId;
	private String keyword;

	private List<Product> products;
	private List<Category> categories;
	private List<Supplier> suppliers;

	public ProductController() {

		String passProductId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("product_id");

		ProductService proService = new ProductService();

		if (passProductId != null) {

			productId = Long.valueOf(passProductId);

			Product product = proService.getProduct(productId);

			name = product.getName();
			price = product.getPrice();
			stock = product.getStock();
			description = product.getDescription();
			categoryId = product.getCategory().getId();
			supplierId = product.getSupplier().getId();

		}

		categories = proService.getAllCategories();
		suppliers = proService.getAllSuppliers();

	}

	public String searchByName() {

		ProductService proService = new ProductService();

		this.products = proService.searchByNameService(this.keyword);

		ProductListController proListController = new ProductListController();
		proListController.setPrd(null);

		return "list";

	}

	public String save() {

		ProductService proService = new ProductService();

		Category category = proService.getCategory(this.categoryId);
		Supplier supplier = proService.getSupplier(this.supplierId);
		Product product = new Product(this.name, this.price, this.stock,
				this.description);

		// jika productId not null, update
		product.setId(this.productId);

		product.setCategory(category);
		product.setSupplier(supplier);

		proService.saveService(product);

		return "listproduct";

	}

	public void delete() {

		String passProductId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("idDelete");
		this.productId = Long.valueOf(passProductId);

		ProductService proService = new ProductService();
		proService.deleteService(this.productId);

		// update object list, setelah dihapus
		ProductListService proListService = new ProductListService();
		List<Product> products = proListService.getAllProduct();

		ProductListController proListController = new ProductListController();
		proListController.setPrd(products);

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			externalContext.redirect("listproduct.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
