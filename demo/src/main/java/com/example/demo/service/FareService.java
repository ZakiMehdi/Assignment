package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

@Service
public class FareService {

	 @Autowired
	    private OAuth2RestOperations restOperations;

	    public String getFares(String origin, String dest) {
	    	try {

	            String url = "http://localhost:8080/fares";
	            	url = url.concat("/"+origin);
	            	url = url.concat("/"+dest);        	
	            System.out.println("Calling " + url);
	        	ResponseEntity<Object> responseEntity = restOperations.getForEntity(url, Object.class);
	            if (responseEntity.getStatusCode().is2xxSuccessful()) {
	                
	                return responseEntity.toString();
	            }
	            
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    	 return "";
	    }
}
