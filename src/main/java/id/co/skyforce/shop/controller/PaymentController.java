package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.PaymentMethod;
import id.co.skyforce.shop.service.PaymentService;
import id.co.skyforce.shop.util.HibernateUtil;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
public class PaymentController {

	private Long paymentId;
	private String name;
	
	private List<PaymentMethod> payMethod;
	
	public PaymentController() {
		
		String passPaymentId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("payment_id");

		PaymentService payService = new PaymentService();

		if (passPaymentId != null) {

			this.paymentId = Long.valueOf(passPaymentId);

			PaymentMethod payMethod = payService.getPayMethod(paymentId);
			name = payMethod.getName();
			
		} else {
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			
			payMethod = session.createQuery("FROM PaymentMethod").list();
			
			trx.commit();
			session.close();
			
		}

	}
	
	public String save() {

		PaymentService payService = new PaymentService();

		PaymentMethod payMethod = new PaymentMethod();
		payMethod.setName(name);

		// jika paymentId not null, update
		payMethod.setId(paymentId);

		payService.saveService(payMethod);

		return "listpayment";

	}

	public void delete() {

		String passPaymentId = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("payment_id");
		this.paymentId = Long.valueOf(passPaymentId);

		PaymentService payService = new PaymentService();
		payService.deleteService(this.paymentId);

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			externalContext.redirect("listpayment.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PaymentMethod> getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(List<PaymentMethod> payMethod) {
		this.payMethod = payMethod;
	}
	
}
