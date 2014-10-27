package id.co.skyforce.shop.service;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.model.Product;
import id.co.skyforce.shop.util.HibernateUtil;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

/**
 * 
 * @author Saddam Hussein
 *
 */

public class LoginService {
	
	//String url;

	Customer cust = new Customer();
	public boolean login(String email, String password){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("from Customer c where c.email=:email and c.password=:password");
		query.setString("email", email);
		query.setString("password", password);
		List<Customer> result = query.list();
		trx.commit();
		session.close();
		if (!result.isEmpty()){
			cust = result.get(0);
			return true;
		}
		else {
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unknown login, try again"));
			return false;
		}
	}
	
	public Customer getCustomer(){
		return cust;
	}
	
	public String logout(){
		cust= null; 
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	     return "/index";
	}

}
