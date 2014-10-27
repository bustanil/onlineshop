package id.co.skyforce.shop.service;
/**
 * 
 * @author Saddam Hussein
 *
 */

import id.co.skyforce.shop.model.Order;
import id.co.skyforce.shop.model.OrderDetail;
import id.co.skyforce.shop.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TransHistoryDetailService {
	public List getAllOrderDetail(Long idOrder){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("from OrderDetail od where od.order.id=:idOrder");
		query.setLong("idOrder", idOrder);
		List <OrderDetail> orderDetailList =  query.list();
		
		trx.commit();
		session.close();
		return orderDetailList;
	}
}
