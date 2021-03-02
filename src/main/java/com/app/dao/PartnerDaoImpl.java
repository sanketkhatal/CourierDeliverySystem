package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;
@Repository
public class PartnerDaoImpl implements IPartnerDao {
	
	@PersistenceContext
	EntityManager mgr;

	@Override
	public String registerPartner(DeliveryPartner partner) {
		String message =  "Partner Registration failed";
		mgr.persist(partner);
		 message =  "Partner Registration successful";	
		return message;
	}

	@Override
	public DeliveryPartner authenticatePartner(String email, String password) {
		// TODO Auto-generated method stub
				System.out.println("in authenticate delivery partner");
				String jpql = "select d from DeliveryPartner d where d.demail=:em and d.dpassword=:pa";
				return mgr.createQuery(jpql,DeliveryPartner.class).setParameter("em", email).
						setParameter("pa", password).getSingleResult();
	}

	@Override
	public List<Orders> getOrders(int did) {
		// TODO Auto-generated method stub
		System.out.println("In get orders delivery partner");
		String jpql = "select o from Orders o where o.selectedPartner.did =:did";
		return mgr.createQuery(jpql , Orders.class).setParameter("did", did).getResultList();
	}

	@Override
	public List<Orders> getPendingOrders(int did) {
		// TODO Auto-generated method stub
		System.out.println("In get Pending orders delivery partner");
		String jpql = "select o from Orders o where o.selectedPartner.did =:did and o.orderStatus='pending'";
		return mgr.createQuery(jpql , Orders.class).setParameter("did", did).getResultList();
	}

	@Override
	public Customer getCustomerDetails(int orderId) {
		// TODO Auto-generated method stub
		Orders o = mgr.find(Orders.class, orderId);
		return o.getSelectedCustomer();
	}

	@Override
	public String updateOrderStatus(int orderId) {
		// TODO Auto-generated method stub
		Orders o  = mgr.find(Orders.class, orderId);
		o.setOrderStatus("delivered");
		
		return "delivered successfully";
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

	@Override
	public DeliveryPartner updatePartner(DeliveryPartner d) {
		// TODO Auto-generated method stub
		DeliveryPartner updatePartner = mgr.find(DeliveryPartner.class, d.getDid());
		updatePartner.setDname(d.getDname());
		updatePartner.setDemail(d.getDemail());
		updatePartner.setDmobileno(d.getDmobileno());
		updatePartner.setArea(d.getArea());
		updatePartner.setLicenceno(d.getLicenceno());
		
		
		return mgr.merge(updatePartner);
	}

	@Override
	public DeliveryPartner updateEarning(int id) {
		// TODO Auto-generated method stub
		DeliveryPartner updatePartner = mgr.find(DeliveryPartner.class, id);
		updatePartner.setEarning(updatePartner.getEarning() + 200);
		return mgr.merge(updatePartner);
	
	}
	
	
	

		

}
