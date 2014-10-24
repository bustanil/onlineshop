package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.util.HibernateUtil;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SupplierDetailService {

	public Supplier getDetailSupplier(){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		long id = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id"));
		
		Supplier supplier = (Supplier) session.get(Supplier.class, id);
		
		session.save(supplier);
		trx.commit();
		return supplier;
	}
}
