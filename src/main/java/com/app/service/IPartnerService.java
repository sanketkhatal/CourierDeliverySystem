package com.app.service;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.DeliveryPartner;
import com.app.pojos.Orders;

public interface IPartnerService {
	
	String registerPartner(DeliveryPartner partner);
	DeliveryPartner authenticatePartner(String email, String password);
	List<Orders> getorders(int did);
	List<Orders> getPendingOrders(int did);
	Customer getCustomerDetails(int orderId);
	String updateOrderStatus(int orderId);
	String deletePartner(int did);
	DeliveryPartner updatePartner(DeliveryPartner d);
	DeliveryPartner updateEarning(int id);
	
}
