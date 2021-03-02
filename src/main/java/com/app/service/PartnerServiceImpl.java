package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPartnerDao;
import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;

@Service
@Transactional
public class PartnerServiceImpl implements IPartnerService {
	
	@Autowired
	IPartnerDao dao;
	

	@Override
	public String registerPartner(DeliveryPartner partner) {
		// TODO Auto-generated method stub
		System.out.println("In register Partner service");
		return dao.registerPartner(partner);
	}


	@Override
	public DeliveryPartner authenticatePartner(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authenticatePartner( email, password);
	}


	@Override
	public List<Orders> getorders(int did) {
		// TODO Auto-generated method stub
		System.out.println("In getorder delivery service");
		return dao.getOrders(did);
	}


	@Override
	public List<Orders> getPendingOrders(int did) {
		// TODO Auto-generated method stub
		return dao.getPendingOrders(did);
	}


	@Override
	public Customer getCustomerDetails(int orderId) {
		// TODO Auto-generated method stub
		return dao.getCustomerDetails(orderId);
	}


	@Override
	public String updateOrderStatus(int orderId) {
		// TODO Auto-generated method stub
		return dao.updateOrderStatus(orderId);
	}


	@Override
	public String deletePartner(int did) {
		// TODO Auto-generated method stub
		return dao.deletePartner(did);
	}


	@Override
	public DeliveryPartner updatePartner(DeliveryPartner d) {
		// TODO Auto-generated method stub
		return dao.updatePartner(d);
	}


	@Override
	public DeliveryPartner updateEarning(int id) {
		// TODO Auto-generated method stub
		return dao.updateEarning(id);
	}



}
