package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vid;
	
	@Column(length = 30, name = "vtype")
	private String vehicleType;
	
	@Column(length = 30 )
	private String vname;
	
	@Column(length = 30)
	private String vreg;
	
	@OneToOne
	@JoinColumn(name = "dpartner_id")
	private DeliveryPartner dpartner;
	
	public Vehicle() {
		System.out.println("In vehicle Default Constructor");
	}

	public Vehicle(Integer vid, String vehicleType, String vname, String vreg, DeliveryPartner dpartner) {
		super();
		this.vid = vid;
		this.vehicleType = vehicleType;
		this.vname = vname;
		this.vreg = vreg;
		this.dpartner = dpartner;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVreg() {
		return vreg;
	}

	public void setVreg(String vreg) {
		this.vreg = vreg;
	}

	public DeliveryPartner getDpartner() {
		return dpartner;
	}

	public void setDpartner(DeliveryPartner dpartner) {
		this.dpartner = dpartner;
	}

	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", vehicleType=" + vehicleType + ", vname=" + vname + ", vreg=" + vreg
				+ ", dpartner=" + dpartner + "]";
	}
	
	

}
