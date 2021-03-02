package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	
	@PersistenceContext
	EntityManager mgr;

	@Override
	public String registerCustomer(Customer customer) {
		String message =  "Customer Registration failed";
		Customer c= mgr.merge(customer);
		System.out.println(c);
		 message =  "Customer Registration successful";	
		return message;
	}

	@Override
	public Customer authenticateCustomer(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("in authenticate customer");
		String jpql = "select c from Customer c where c.cemail=:em and c.cpassword=:pa";
		return mgr.createQuery(jpql,Customer.class).setParameter("em", email).
				setParameter("pa", password).getSingleResult();
		
		
	}

	@Override
	public List<String> placeOrderArea() {
		 System.out.println("In Place Order area");
		String jpql = "select d.area from DeliveryPartner d";
		List<String>list = (List<String>)mgr.createQuery(jpql,String.class).getResultList();
		return list;
	}

	@Override
	public String placeOrder(Orders order, Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("In place order");
		mgr.persist(order);
		
		String jpql = "select d from DeliveryPartner d where d.area=:ar";
		DeliveryPartner d = mgr.createQuery(jpql,DeliveryPartner.class).setParameter("ar", order.getArea()).
				getSingleResult();
		Orders o  = mgr.find(Orders.class, order.getOrderId());
		o.setSelectedCustomer(customer);
		d.addDelOrders(o);
		
		
		return "success with order ID : " + o.getOrderId();
	}

	@Override
	public DeliveryPartner getDeliveryPartner(Orders order) {
		// TODO Auto-generated method stub
		String jpql = "select d from DeliveryPartner d where d.area=:ar";
		DeliveryPartner d = mgr.createQuery(jpql,DeliveryPartner.class).
				setParameter("ar",order.getArea()).getSingleResult();
		return d;
	}

	@Override
	public List<Orders> getMyOrders() {
		String jpql = "select o from Orders o";
		List<Orders> orders = (List<Orders>)mgr.createQuery(jpql,Orders.class).getResultList();
		return orders;
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer updateCustomer = mgr.find(Customer.class, c.getCid());
		updateCustomer.setCname(c.getCname());
		updateCustomer.setCemail(c.getCemail());
		updateCustomer.setCmobile(c.getCmobile());
		updateCustomer.setCaddress(c.getCaddress());
		
		return mgr.merge(updateCustomer);
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

}
