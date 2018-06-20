package com.vehicle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vehicle.dao.DataDao;
import com.vehicle.model.Vehicle;
import com.vehicle.services.DataServices;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(Vehicle vehicle) throws Exception {
		return dataDao.addEntity(vehicle);
	}
	
	@Override
	public boolean updateEntity(Vehicle vehicle) throws Exception {
		return dataDao.updateEntity(vehicle);
	}

	@Override
	public Vehicle getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Vehicle> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
