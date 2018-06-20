package com.vehicle.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vehicle.model.Status;
import com.vehicle.model.Vehicle;
import com.vehicle.services.DataServices;


@Controller
@RequestMapping("/vehicle")
public class RestController {
	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addVehicle(@RequestBody Vehicle vehicle) {
		try {
			dataServices.addEntity(vehicle);
			return new Status(1, "Vehicle added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Vehicle getVehicle(@PathVariable("id") long id) {
		Vehicle vehicle = null;
		try {
			vehicle = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Vehicle> getVehicle() {

		List<Vehicle> vehicleList = null;
		try {
			vehicleList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vehicleList;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status updateVehicle(@RequestBody Vehicle vehicle) {
		try {
			dataServices.updateEntity(vehicle);
			return new Status(1, "Vehicle updated Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteVehicle(@PathVariable("id") long id) {
		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Vehicle deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}