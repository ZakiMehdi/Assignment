package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AirportLocationsService;

import io.micrometer.core.annotation.Timed;

@RestController
public class AirportLocationsController {

	@Autowired
	private AirportLocationsService airportLocationsService;

	@Timed(
			value = "travel.getAirportList.requests",
			histogram = true,
					percentiles = {0.95, 0.99},
			extraTags = {"version","1.0"}
			)
	@RequestMapping(value = "/getAirportList", method = RequestMethod.GET, produces = "application/json")
	public String getAirportList(@RequestParam(value = "key", required = false) String key) {

		return airportLocationsService.getAirportList(key);

	}

}
