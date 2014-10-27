package id.co.skyforce.shop.controller;

/**
 * 
 * @author Saddam Hussein
 *
 */

import id.co.skyforce.shop.model.Order;
import id.co.skyforce.shop.service.TransactioHistoryService;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class TransactionHistoryController {
	private List <Order> orderList;
	
	public TransactionHistoryController(){
		Long idCustomer = Long.parseLong(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("idcustomer"));
		TransactioHistoryService ths = new TransactioHistoryService();
		orderList = ths.getAllOrder(idCustomer);
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}



}
