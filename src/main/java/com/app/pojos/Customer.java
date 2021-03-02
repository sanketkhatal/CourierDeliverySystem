package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	
	@Column(length = 30 )
	private String cname;
	
	@Column(length = 30 , unique = true)
	private String cemail;
	
	@Column(length = 10 ,unique = true )
	private String cmobile;
	
	@Column(length = 30 )
	private String cpassword;
	
	@Column(length = 45)
	private String caddress;
	@OneToMany(mappedBy = "selectedCustomer",cascade = CascadeType.ALL)
	private List<Orders> placeOrders  =new ArrayList<>();
	
	
	//default constructor
	public Customer() {
		super();
		System.out.println("In Customer Default Constructor");
	}
	
	

	//paramerized constructor 
	public Customer(Integer cid, String cname, String cemail, String cmobile, String cpassword, String caddress,
			List<Orders> placeOrders) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.cmobile = cmobile;
		this.cpassword = cpassword;
		this.caddress = caddress;
		this.placeOrders = placeOrders;
	}
	
	
	

	public Customer(Integer cid,String cname, String cemail, String cmobile, String caddress, String cpassword ) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.cmobile = cmobile;
		this.caddress = caddress;
		this.cpassword = cpassword;
	}



	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCemail() {
		return cemail;
	}


	public void setCemail(String cemail) {
		this.cemail = cemail;
	}


	public String getCmobile() {
		return cmobile;
	}


	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}


	public String getCpassword() {
		return cpassword;
	}


	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}


	public String getCaddress() {
		return caddress;
	}


	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	public List<Orders> getPlaceOrders() {
		return placeOrders;
	}


	public void setPlaceOrders(List<Orders> placeOrders) {
		this.placeOrders = placeOrders;
	}


	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cmobile=" + cmobile
				+ ", cpassword=" + cpassword + ", caddress=" + caddress + "]";
	}
	
		
	
}