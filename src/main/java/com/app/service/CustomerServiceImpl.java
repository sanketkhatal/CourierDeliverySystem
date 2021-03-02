package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerDao dao;

	@Override
	public String registerCustomer(Customer customer) {
		
		return dao.registerCustomer(customer);
	}

	@Override
	public Customer authenticateCustomer(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authenticateCustomer(email, password);
	}

	@Override
	public List<String> placeOrderArea() {
		
		return dao.placeOrderArea();
	}

	@Override
	public String placeOrder(Orders order, Customer customer) {
		// TODO Auto-generated method stub
		return dao.placeOrder(order,customer);
	}

	@Override
	public DeliveryPartner getDeliveryPartner(Orders order) {
		// TODO Auto-generated method stub
		return dao.getDeliveryPartner(order);
	}

	@Override
	public List<Orders> getMyOrders() {
		// TODO Auto-generated method stub
		return dao.getMyOrders();
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		return dao.updateCustomer(c);
	}

	@Override
	public String deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(cid);
	}

}
