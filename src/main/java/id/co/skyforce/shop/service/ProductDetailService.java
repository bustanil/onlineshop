package id.co.skyforce.shop.service;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.util.HibernateUtil;

public class ProductDetailService {
	public Product getDetailProduct() {

		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		long id = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id"));
		
		Product product = (Product) session.get(Product.class,id);

		session.save(product);
		trx.commit();

		return product;
	}
}
