package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.PaymentMethod;
import id.co.skyforce.shop.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;

public class PaymentListService {

	public List getAllPayments() {

		List<PaymentMethod> payMethods;

		Session session = HibernateUtil.openSession();

		payMethods = session.createQuery("FROM PaymentMethod").list();

		session.close();

		return payMethods;

	}

}
