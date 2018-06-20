package com.vehicle.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "vehicle")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "vehicle_name")
	private String vehicle_name;
	
	@Column(name = "model_name")
	private String model_name;
	
	@Column(name = "vehicle_type")
	private String vehicle_type;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "price")
	private int price;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicleName() {
		return vehicle_name;
	}

	public void setVehicleName(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public String getModelName() {
		return model_name;
	}

	public void setModelName(String model_name) {
		this.model_name = model_name;
	}

	public String getVehicleType() {
		return vehicle_type;
	}

	public void setVehicleType(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
