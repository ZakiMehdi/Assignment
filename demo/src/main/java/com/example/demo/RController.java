package com.example.demo;

import com.example.demo.model.Embedded;
import com.example.demo.model.Location;
import com.example.demo.model.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RController {

    @Autowired
    private OAuth2RestOperations restOperations;

    @RequestMapping(value = "/getAirportList", method = RequestMethod.GET, produces = "application/json")
    public String getAirportList(@RequestParam(value = "key", required = false) String key) {
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
    
    @RequestMapping(value = "/getFares", method = RequestMethod.GET, produces = "application/json")
    public String getFares(@RequestParam(value = "origin", required = true) String origin,@RequestParam(value = "dest", required = true) String dest) {
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
