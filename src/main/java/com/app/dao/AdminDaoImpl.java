package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;

@Repository
public class AdminDaoImpl implements IAdminDao {
	
	@PersistenceContext
	EntityManager mgr;

	@Override
	public Admin authenticateAdmin(String email, String password) {
		
			// TODO Auto-generated method stub
			System.out.println("in authenticate Admin");
			String jpql = "select a from Admin a where a.aemail=:em and a.apassword=:pa";
			return mgr.createQuery(jpql,Admin.class).setParameter("em", email).
					setParameter("pa", password).getSingleResult();
			
			
		}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String jpql =  "select c from Customer c";
		
		return mgr.createQuery(jpql,Customer.class).getResultList();
	}

	@Override
	public List<DeliveryPartner> getAllPartners() {
		// TODO Auto-generated method stub
		String jpql = "select d from DeliveryPartner d";
		
		return mgr.createQuery(jpql,DeliveryPartner.class).getResultList();
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		String jpql = "select o from Orders o";
		return mgr.createQuery(jpql , Orders.class).getResultList();
	}
	
	@Override
	public String deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		System.out.println("in delete customer dao");
		Customer c = mgr.find(Customer.class, cid);
		if(c != null) {
			
		mgr.remove(c);
		System.out.println("Removing customer");
		return "removed successfully";
		}
		
		
		return "customer removing failed";
	}

	
	
	@Override
	public String deletePartner(int did) {
		// TODO Auto-generated method stub
		System.out.println("in delete partner dao");
		DeliveryPartner d = mgr.find(DeliveryPartner.class, did);
		if(d != null) {
			
			mgr.remove(d);
			System.out.println("Removing partner");
			return "removed successfully";
		}
		
		return "partner removing failed";
	}
}
