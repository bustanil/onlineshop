package id.co.skyforce.shop.controller;

import id.co.skyforce.shop.model.Order;
import id.co.skyforce.shop.model.OrderDetail;
import id.co.skyforce.shop.service.TransHistoryDetailService;
import id.co.skyforce.shop.service.TransactioHistoryService;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TransHistoryDetailController {
private List <OrderDetail> orderDetailList;
	
	public TransHistoryDetailController(){
		Long idOrder = Long.parseLong(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("idOrder"));
		TransHistoryDetailService thds = new TransHistoryDetailService();
		orderDetailList = thds.getAllOrderDetail(idOrder);
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

}
