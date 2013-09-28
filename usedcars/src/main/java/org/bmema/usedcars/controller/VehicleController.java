package org.bmema.usedcars.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.bmema.usedcars.dao.Dao;
import org.bmema.usedcars.entity.Vehicle;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VehicleController {
	protected static Logger logger = Logger.getLogger("Vehicle Controller");

	@Autowired
	private Dao dao;
	
	@Autowired
	ObjectMapper jacksonMapper;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		logger.info("	Received request to show the home page");
		return "home";
	}
	
	@RequestMapping(value = "/vehicleDetails/{licensePlate}", method = RequestMethod.GET)
	public @ResponseBody String get(@PathVariable String licensePlate, Model model) {
		logger.info("	Received request to retrieve a vehicle");
		
		try {
			return jacksonMapper.writeValueAsString(dao.getVehicle(licensePlate));
		} catch (IOException e) {
			logger.error("Cannot parse JSON request", e);
			return "Error";
		}
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody String search(@RequestBody String request) {
		logger.debug("	Received request to search for vehicles");
		 
		try {
			Vehicle criteria = jacksonMapper.readValue(request, Vehicle.class);
			return jacksonMapper.writeValueAsString(dao.getVehicles(criteria));
		} catch (IOException e) {
			logger.error("Cannot parse JSON request", e);
			return "Error";
		}
	}	
	
//	@RequestMapping(value = "/search", method = RequestMethod.POST)			//with Jacksonmapping
//	public String postSearch(@ModelAttribute("vehicle") Vehicle criteria) {
//		logger.debug("Received request to search for search poi");
//		 
//		List<Poi> result = poiService.search(criteria);
//
//		return "home";
//	}
	
	
	
}
