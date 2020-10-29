package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.model.Location;
import com.example.demo.model.ResponseBody;

@Service
public class AirportLocationsService {

	 @Autowired
	    private OAuth2RestOperations restOperations;
	 
	    public String getAirportList(String key) {
	    	try {

	            String url = "http://localhost:8080/airports";
	            if (!StringUtils.isEmpty(key)) {
	            	
	            	url = url.concat("/"+key);
	            	System.out.println("Calling " + url);
	            	ResponseEntity<Location> responseEntityLocation = restOperations.getForEntity(url, Location.class);
	            			if (responseEntityLocation.getStatusCode().is2xxSuccessful()) {
	            				Location responseLocation = responseEntityLocation.getBody();
	            				return responseLocation.toString();
	            			}
	            }
	            ResponseEntity<ResponseBody> responseEntity = restOperations.getForEntity(url, ResponseBody.class);
	            if (responseEntity.getStatusCode().is2xxSuccessful()) {
	                ResponseBody responseBody = responseEntity.getBody();
	                return responseBody.toString();
	            }
	            
	        
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	  return "";
	    }

}
