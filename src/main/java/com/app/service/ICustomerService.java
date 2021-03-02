package com.app.service;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;

public interface ICustomerService {
	
	String registerCustomer(Customer customer);
	Customer authenticateCustomer(String email , String password);
	List<String> placeOrderArea();
	String placeOrder(Orders order, Customer customer);
	DeliveryPartner getDeliveryPartner(Orders order);
	List<Orders> getMyOrders(); 
	Customer updateCustomer(Customer c);
	String deleteCustomer(int cid);

}
