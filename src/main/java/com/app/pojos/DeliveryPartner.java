package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "delivery_partner")
public class DeliveryPartner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer did;
	
	@Column(length = 30)
	private String dname;
	
	@Column(length = 10)
	private String dmobileno;
	
	@Column(length = 30, unique = true)
	private String demail;
	
	@Column(length = 30)
	private String dpassword;
	
	@Column(length = 30)
	private String availability;
	
	@Column(length = 30) 
	private String area;
	
	@Column(length = 15)
	private String licenceno;

	private double earning;
	
	@OneToMany(mappedBy = "selectedPartner",cascade = CascadeType.ALL)
	private List<Orders>deliveredOrders = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Vehicle selectedvehicle;
	
	
	public DeliveryPartner() {
		super(); 
		System.out.println("in DeliveryPartner Default Contructor");
		
	}

	public DeliveryPartner(Integer did, String dname, String dmobileno, String demail, String availability,
			String dpassword, String area, String licenceno, double earning, List<Orders> deliveredOrders,
			Vehicle selectedvehicle) {
		super();
		this.did = did;
		this.dname = dname;
		this.dmobileno = dmobileno;
		this.demail = demail;
		this.availability = availability;
		this.dpassword = dpassword;
		this.area = area;
		this.licenceno = licenceno;
		this.earning = earning;
		this.deliveredOrders = deliveredOrders;
		this.selectedvehicle = selectedvehicle;
	}
	
	
	
	
	

	public DeliveryPartner(Integer did, String dname, String demail, String dmobileno, String area, String licenceno) {
		super();
		this.did = did;
		this.dname = dname;
		this.demail = demail;
		this.dmobileno = dmobileno;
		this.area = area;
		this.licenceno = licenceno;
	}

	public DeliveryPartner(String dname,  String demail , String dpassword,String dmobileno, String area,
			String licenceno) {
		//DeliveryPartner(name,email,pass,mobile,area,license );
		super();
		this.dname = dname;
		this.dmobileno = dmobileno;
		this.demail = demail;
		this.dpassword = dpassword;
		this.area = area;
		this.licenceno = licenceno;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDmobileno() {
		return dmobileno;
	}

	public void setDmobileno(String dmobileno) {
		this.dmobileno = dmobileno;
	}

	public String getDemail() {
		return demail;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getDpassword() {
		return dpassword;
	}

	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLicenceno() {
		return licenceno;
	}

	public void setLicenceno(String licenceno) {
		this.licenceno = licenceno;
	}

	public double getEarning() {
		return earning;
	}

	public void setEarning(double earning) {
		this.earning = earning;
	}

	public List<Orders> getDeliveredOrders() {
		return deliveredOrders;
	}

	public void setDeliveredOrders(List<Orders> deliveredOrders) {
		this.deliveredOrders = deliveredOrders;
	}

	public Vehicle getSelectedvehicle() {
		return selectedvehicle;
	}

	public void setSelectedvehicle(Vehicle selectedvehicle) {
		this.selectedvehicle = selectedvehicle;
	}

	@Override
	public String toString() {
		return "DeliveryPartner [did=" + did + ", dname=" + dname + ", dmobileno=" + dmobileno + ", demail=" + demail
				+ ", availability=" + availability + ", dpassword=" + dpassword + ", area=" + area + ", licenceno="
				+ licenceno + ", earning=" + earning + ", deliveredOrders=" + deliveredOrders + "]";
	}
	
	public void addDelOrders(Orders o) {
		deliveredOrders.add(o);
		o.setSelectedPartner(this);
	}
	
	
	
	
	

}
