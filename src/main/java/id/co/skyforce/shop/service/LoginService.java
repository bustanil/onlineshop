package id.co.skyforce.shop.service;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.shop.model.Customer;
import id.co.skyforce.shop.util.HibernateUtil;

public class LoginService {

	public static Query query;
	Customer cus = new Customer();
	public Customer login(Customer customer){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		query = session.createQuery("from Customer where email = :email and password =:password ");
		query.setString("email", customer.getEmail());
		query.setString("password", customer.getPassword());
		
		customer = (Customer) query.uniqueResult();
		return customer;
	}
	/*query = session.createQuery(hqlStatement);
		query.setString("search_string", "%" + searchString + "%");
		daftarProdukDicari = query.list();

		for (Product product : daftarProdukDicari) {
			System.out.printf("%-3d %-15s %-15s %15.0f %4d\n", product.getId(),
					product.getCategory().getName(), product.getName(),
					product.getPrice(), product.getStock());
		}

		daftarProdukDicari = null;

		System.out.println();
	}*/
}
