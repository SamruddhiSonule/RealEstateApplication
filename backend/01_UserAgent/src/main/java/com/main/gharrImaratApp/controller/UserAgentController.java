package com.main.gharrImaratApp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.UserAgent;
import com.main.gharrImaratApp.service.UserAgentServiceInterface;

@RestController
@CrossOrigin("*")
public class UserAgentController {

	@Autowired UserAgentServiceInterface userAgentServiceInterface;
	
	@PostMapping("users/agent")
	public ResponseEntity<UserAgent> addUserAgentRecord(@RequestBody UserAgent userAgent){
		UserAgent userAg=userAgentServiceInterface.addUserAgentRecord(userAgent);
		
		return new ResponseEntity<UserAgent>(userAg, HttpStatus.CREATED);
	} // add Agent details
	
	@PutMapping("users/agent/update/{userAgent1ID}/{userAgent2ID}")
	public ResponseEntity<UserAgent> updateUserAgentRecord(@PathVariable UUID userAgent1ID,@PathVariable UUID userAgent2ID,@RequestBody UserAgent userAgent)
	{
		UserAgent userAgent2= userAgentServiceInterface.updateUserAgentRecord(userAgent1ID,userAgent2ID,userAgent);
		return new ResponseEntity<UserAgent>(userAgent2, HttpStatus.OK);
	}
	@GetMapping("/users/agent")
	public ResponseEntity<Iterable<UserAgent>> viewAllUserAgentRecords()
	{
		Iterable<UserAgent> list=userAgentServiceInterface.viewAllUserAgentRecords();
		return new ResponseEntity<Iterable<UserAgent>>(list, HttpStatus.OK);
	} // get all agents Details
	
	@PutMapping("/users/agent/{userAgent1ID}/{userAgent2ID}")
	public ResponseEntity<UserAgent> upadteUserAgentRecord(@PathVariable UUID userAgent1ID, 
			@PathVariable UUID userAgent2ID, @RequestBody PropertyRentAndBuy propertiest)
	{
		
		UserAgent updatedAgent=userAgentServiceInterface.upadteUserAgentRecord(userAgent1ID, userAgent2ID, propertiest);
		
		return new ResponseEntity<>(updatedAgent, HttpStatus.OK);
		
	}// update Agent details using id's   // checks again 
	
	@DeleteMapping("/users/agent/delete/{userAgent1ID}/{userAgent2ID}")
	public ResponseEntity<UserAgent> deleteAgentRecord(@PathVariable UUID userAgent1ID, @PathVariable UUID userAgent2ID) {
	    UserAgent userAgent = userAgentServiceInterface.deleteAgentRecord(userAgent1ID, userAgent2ID);
	    return new ResponseEntity<UserAgent>(userAgent, HttpStatus.NO_CONTENT);
	}// Delete Single Agent Record using ID
	
	@GetMapping("/users/agent/{userAgent1ID}/{userAgent2ID}")
	public Optional<UserAgent> getSingleUserAgentRecord(@PathVariable UUID userAgent1ID, @PathVariable UUID  userAgent2ID)
	{
		Optional<UserAgent> userAgent=userAgentServiceInterface.getSingleUserAgentRecord(userAgent1ID, userAgent2ID);
		
		 
		return 	userAgent;
	} // get single Agent details using ID's
			
	
	@GetMapping("/users/agent/email/password/{userAgentPassword}/{userAgentEmail}")
	public ResponseEntity<UserAgent> getSingleUserAgentRecordByName(@PathVariable String userAgentPassword, @PathVariable String userAgentEmail) {
	    UserAgent singleUserAgent = userAgentServiceInterface.getSingleUserAgentRecordByName(userAgentPassword, userAgentEmail);
	    
	    if (singleUserAgent != null) {
	        return new ResponseEntity<>(singleUserAgent, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}// find agent using agentName and agent email
}


