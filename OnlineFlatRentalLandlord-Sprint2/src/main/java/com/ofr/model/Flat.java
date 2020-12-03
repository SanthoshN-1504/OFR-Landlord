package com.ofr.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Flat")
public class Flat {
	@Id
	@GeneratedValue
	@Column(name = "fId", length = 15)
	private Integer fId;
	@Column(name = "Cost", length = 15)
	private Float cost;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flatAddressId")
	private FlatAddress flatAddress;
	@Column(name = "Availability", length = 15)
	private String availability;
	public Flat() {

	}

	public Flat( Float cost, FlatAddress flatAddress, String availability) {
		super();

		this.cost = cost;
		this.flatAddress = flatAddress;
		this.availability = availability;

	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;	
	}
	
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}

	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}


	@Override
	public String toString() {
		return "Flat [fId=" + fId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", availability=" + availability;
	}

}
