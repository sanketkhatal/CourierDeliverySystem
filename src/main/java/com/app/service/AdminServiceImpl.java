package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminDao dao;
	
	@Override
	public Admin authenticateAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authenticateAdmin(email, password);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}

	@Override
	public List<DeliveryPartner> getAllPartners() {
		// TODO Auto-generated method stub
		return dao.getAllPartners();
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return dao.getAllOrders();
	}

	@Override
	public String deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(cid);
	}

	@Override
	public String deletePartner(int did) {
		// TODO Auto-generated method stub
		return dao.deletePartner(did);
	}

}
