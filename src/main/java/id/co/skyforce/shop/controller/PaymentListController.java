package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.PaymentMethod;
import id.co.skyforce.shop.service.PaymentListService;

import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Irwansyah Hazniel
 *
 */

@ManagedBean
public class PaymentListController {
	
	List<PaymentMethod> payMethod;
	
	public PaymentListController() {
		
		PaymentListService payListService = new PaymentListService();
		
		payMethod = payListService.getAllPayments();
		
	}

	public List<PaymentMethod> getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(List<PaymentMethod> payMethod) {
		this.payMethod = payMethod;
	}
	
}
