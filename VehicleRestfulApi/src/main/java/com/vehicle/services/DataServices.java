package com.vehicle.services;

import java.util.List;

import com.vehicle.model.Vehicle;

public interface DataServices {

	public boolean addEntity(Vehicle vehicle) throws Exception;
	public boolean updateEntity(Vehicle vehicle) throws Exception;
	public Vehicle getEntityById(long id) throws Exception;
	public List<Vehicle> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
