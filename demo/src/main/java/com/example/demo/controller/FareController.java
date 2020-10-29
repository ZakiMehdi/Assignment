package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FareService;

@RestController
public class FareController {

	@Autowired
	private FareService fareService;
	
    @RequestMapping(value = "/getFares", method = RequestMethod.GET, produces = "application/json")
    public String getFares(@RequestParam(value = "origin", required = true) String origin,@RequestParam(value = "dest", required = true) String dest) {
    	return fareService.getFares(origin, dest);
    }
	
	
}
