package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AirportLocationsService;

@RestController
public class AirportLocationsController {

	@Autowired
	private AirportLocationsService airportLocationsService;

	@RequestMapping(value = "/getAirportList", method = RequestMethod.GET, produces = "application/json")
	public String getAirportList(@RequestParam(value = "key", required = false) String key) {

		return airportLocationsService.getAirportList(key);

	}

}
