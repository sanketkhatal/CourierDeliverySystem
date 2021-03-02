package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private double totalBill = 200;
	
	@Column(length = 30)
	private String pickAddress;
	
	@Column(length = 30)
	private String dropAddress;
	
	@Column(length = 30)
	private String area;
	
	@Column(length = 10)
	private String sendermobile;
	
	@Column(length = 10)
	private String receivermobile;
	
	@Column(length = 30)
	private String paymentstatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer selectedCustomer;
	
	@ManyToOne
	@JoinColumn(name = "partner_id")
	private DeliveryPartner selectedPartner;
	
	private String orderStatus ="pending";
	
	public Orders() {
		super();
		System.out.println("in Orders default constructor");
	}
	
	

	



	public Orders(String pickAddress, String dropAddress, String area, String sendermobile, String receivermobile,
			Date deliveryDate) {
		super();
		System.out.println("In Order para constructor");
		this.pickAddress = pickAddress;
		this.dropAddress = dropAddress;
		this.area = area;
		this.sendermobile = sendermobile;
		this.receivermobile = receivermobile;
		this.deliveryDate = deliveryDate;
	}







	public Orders(Integer orderId, double totalBill, String pickAddress, String dropAddress, String area,
			String sendermobile, String receivermobile, String paymentstatus, Date deliveryDate,
			Customer selectedCustomer, DeliveryPartner selectedPartner, String orderStatus) {
		super();
		this.orderId = orderId;
		this.totalBill = totalBill;
		this.pickAddress = pickAddress;
		this.dropAddress = dropAddress;
		this.area = area;
		this.sendermobile = sendermobile;
		this.receivermobile = receivermobile;
		this.paymentstatus = paymentstatus;
		this.deliveryDate = deliveryDate;
		this.selectedCustomer = selectedCustomer;
		this.selectedPartner = selectedPartner;
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public String getPickAddress() {
		return pickAddress;
	}

	public void setPickAddress(String pickAddress) {
		this.pickAddress = pickAddress;
	}

	public String getDropAddress() {
		return dropAddress;
	}

	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSendermobile() {
		return sendermobile;
	}

	public void setSendermobile(String sendermobile) {
		this.sendermobile = sendermobile;
	}

	public String getReceivermobile() {
		return receivermobile;
	}

	public void setReceivermobile(String receivermobile) {
		this.receivermobile = receivermobile;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	public DeliveryPartner getSelectedPartner() {
		return selectedPartner;
	}

	public void setSelectedPartner(DeliveryPartner selectedPartner) {
		this.selectedPartner = selectedPartner;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", totalBill=" + totalBill + ", pickAddress=" + pickAddress
				+ ", dropAddress=" + dropAddress + ", area=" + area + ", sendermobile=" + sendermobile
				+ ", receivermobile=" + receivermobile + ", paymentstatus=" + paymentstatus + ", deliveryDate="
				+ deliveryDate + ", selectedCustomer=" + selectedCustomer + ", orderStatus=" + orderStatus + "]";
	}
	
	
	
	
	
		
	
	
	
	

}
