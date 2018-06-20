package com.vehicle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vehicle.model.Vehicle;

public class DataDaoImpl implements DataDao
{
	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Vehicle vehicle) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(vehicle);
		tx.commit();
		session.close();
		return false;
	}
	
	@Override
	public boolean updateEntity(Vehicle vehicle) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(vehicle);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Vehicle getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Vehicle vehicle = (Vehicle) session.load(Vehicle.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return vehicle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Vehicle> vehicleList = session.createCriteria(Vehicle.class)
				.list();
		tx.commit();
		session.close();
		return vehicleList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Vehicle.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
