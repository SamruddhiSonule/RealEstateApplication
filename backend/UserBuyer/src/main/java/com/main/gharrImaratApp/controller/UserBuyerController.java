package com.main.gharrImaratApp.controller;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.UserBuyer;
import com.main.gharrImaratApp.servicei.UserBuyerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
public class UserBuyerController {
	
	@Autowired UserBuyerService userBuyerService;
	
	//Post:- addUserBuyerRecord(“/users/buyer”)
	@PostMapping("/users/buyer")
	public ResponseEntity<UserBuyer> addUserBuyerDetails(@Valid @RequestBody UserBuyer userBuyer)
	{
		UserBuyer userbuyer = userBuyerService.addUserBuyerDetails(userBuyer);
		return new ResponseEntity<UserBuyer>(userBuyer, HttpStatus.CREATED);
	}
	
	
	//get:- viewUserBuyerRecords(“/users/buyer”)
	@GetMapping("/users/buyer")
	public ResponseEntity<Iterable<UserBuyer>> getAllUserBuyerDetails()
	{
		Iterable<UserBuyer> userBuyerList=userBuyerService.getAllUserBuyerDetails();
		return new ResponseEntity<Iterable<UserBuyer>>(userBuyerList, HttpStatus.OK);
	}
	
	
	// update:- upadteUserBuyerRecord(“/users/buyer/{userBuyer1ID}/{userBuyer2ID}”)
	@PutMapping("/users/buyer/updateUserBuyer/{userBuyer1ID}/{userBuyer2ID}")
    public ResponseEntity<UserBuyer> updateUserBuyerRecordByuserBuyer1ID_and_userBuyer2ID(
            @PathVariable UUID userBuyer1ID,
            @PathVariable UUID userBuyer2ID,
            @RequestBody UserBuyer updatedUserBuyer)
    {
		
		UserBuyer existingUserBuyer=userBuyerService.getSingleUserBuyerRecordByuserBuyer1ID_and_userBuyer2ID(userBuyer1ID, userBuyer2ID);
		if(existingUserBuyer ==null)
		{
			return new ResponseEntity<UserBuyer>(HttpStatus.NOT_FOUND);
		}
		UserBuyer userBuyer=userBuyerService.updateUserBuyerDetails(userBuyer1ID, userBuyer2ID ,updatedUserBuyer);
		return new ResponseEntity<UserBuyer>(updatedUserBuyer, HttpStatus.CREATED);

    }
	
	// Delete: deleteUserBuyerRecord(“/users/buyer/{userBuyer1ID}/{userBuyer2ID}")
	@DeleteMapping("/users/buyer/{userBuyer1ID}/{userBuyer2ID}")
	public ResponseEntity<UserBuyer> deleteUserBuyerRecordByuserBuyer1ID_and_userBuyer2ID(
			@PathVariable UUID userBuyer1ID,
            @PathVariable UUID userBuyer2ID)
	{
		userBuyerService.deleteUserBuyerRecord(userBuyer1ID, userBuyer2ID);
		return new ResponseEntity<UserBuyer>(HttpStatus.OK);
	}
    
	
	//get:- getSingleUserBuyerRecord(“/users/buyer/{userBuyer1ID}/{userBuyer2ID}”)
	@GetMapping("/users/buyer/{userBuyer1ID}/{userBuyer2ID}")
	public UserBuyer getSingleUserBuyerRecordByuserBuyer1ID_and_userBuyer2ID(
			@PathVariable UUID userBuyer1ID,
            @PathVariable UUID userBuyer2ID)
	{
		UserBuyer userBuyer=userBuyerService.getSingleUserBuyerRecordByuserBuyer1ID_and_userBuyer2ID(userBuyer1ID, userBuyer2ID);
		System.out.println(userBuyer);
		return userBuyer;
	}
	
	
	//getSingleUserBuyerRecordByName(“/users/buyer/name/{userBuyerPassword}/{userBuyerEmail}”)
	@GetMapping("/users/buyer/getUsers/{userBuyerEmail}/{userBuyerPassword}")
	public ResponseEntity<UserBuyer> getSingleUserBuyerRecordByNameAndEmail(
			@PathVariable String userBuyerEmail,
			@PathVariable String userBuyerPassword)
	{
		UserBuyer userBuyer=userBuyerService.getSingleUserBuyerRecordByEmailAndPassword(userBuyerEmail, userBuyerPassword);
		System.out.println(userBuyer);
		if (userBuyer != null) 
		{
			return new ResponseEntity<>(userBuyer, HttpStatus.OK);
		} 
		else 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	


}
