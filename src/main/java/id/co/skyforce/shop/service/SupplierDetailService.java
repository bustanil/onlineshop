package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Supplier;
import id.co.skyforce.shop.util.HibernateUtil;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Wirahman
 *
 */

public class SupplierDetailService {

	public Supplier getDetailSupplier(Long supplierId){
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		Supplier supplier = (Supplier) session.get(Supplier.class, supplierId);
		
		session.save(supplier);
		trx.commit();
		
		return supplier;
	}
}
