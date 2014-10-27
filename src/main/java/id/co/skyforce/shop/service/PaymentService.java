package id.co.skyforce.shop.service;

import java.util.List;

import id.co.skyforce.shop.model.PaymentMethod;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentService {
	
	public PaymentMethod saveService(PaymentMethod payMethod) {

		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(payMethod);

		transaction.commit();
		session.close();

		return payMethod;

	}

	public PaymentMethod getPayMethod(Long paymentId) {

		Session session = HibernateUtil.openSession();

		PaymentMethod payMethod = (PaymentMethod) session.get(PaymentMethod.class, paymentId);

		session.close();

		return payMethod;

	}

	public PaymentMethod deleteService(Long paymentId) {

		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		PaymentMethod payMethod = (PaymentMethod) session.get(
				PaymentMethod.class, paymentId);

		session.delete(payMethod);

		transaction.commit();
		session.close();

		return payMethod;

	}

}
