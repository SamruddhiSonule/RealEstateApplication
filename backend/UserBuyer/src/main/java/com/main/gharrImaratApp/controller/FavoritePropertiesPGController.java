package com.main.gharrImaratApp.controller;


import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.main.gharrImaratApp.model.FavoritePropertiesPG;
import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.model.UserBuyer;
import com.main.gharrImaratApp.servicei.FavoritePropertiesPGServicei;

@RestController
public class FavoritePropertiesPGController {
	
	@Autowired FavoritePropertiesPGServicei favoritePropertiesPGServicei;
	
	//put:- updatePropertyByPG(“/properties/buyer/pg/{userBuyer1ID}/{userBuyer2ID}”)
	@PutMapping("/properties/buyer/pg/{userBuyer1ID}/{userBuyer2ID}")
	public ResponseEntity<UserBuyer> addPropertyPGToUserBuyer(
			@PathVariable UUID userBuyer1ID,
			@PathVariable UUID userBuyer2ID,
			@RequestBody FavoritePropertiesPG favoritePropertiesPG)
	{
		UserBuyer userBuyer=favoritePropertiesPGServicei.addPropertyPGToUserBuyer(userBuyer1ID, userBuyer2ID, favoritePropertiesPG);
		
		return new ResponseEntity<UserBuyer>(userBuyer, HttpStatus.CREATED);
	}
	
	
    //get:- getPropertyByPG(“/properties/buyer/pg/{userBuyer1ID}/{userBuyer2ID}”
	@GetMapping("/properties/buyer/pg/{userBuyer1ID}/{userBuyer2ID}")
	public List<FavoritePropertiesPG> getFavoritePropertiesPG(
			@PathVariable UUID userBuyer1ID, @PathVariable UUID userBuyer2ID)
	{
		List<FavoritePropertiesPG> list=favoritePropertiesPGServicei.getFavoritePropertiesPG(userBuyer1ID, userBuyer2ID);
		return list;
	}

	
	// get:- getPropertyPGByNoOfBedsAvailable(“/property/agent/pg/beds/{totalNoOfBeds}”)
	@GetMapping("/property/agent/pg/beds/{totalNoOfBeds}")
	public List<FavoritePropertiesPG> getPropertyPGByNoOfBedsAvailable(
			@PathVariable String totalNoOfBeds)
	{
		List<FavoritePropertiesPG> list=favoritePropertiesPGServicei.getPropertyPGByNoOfBedsAvailabl(totalNoOfBeds);
		return list;
	}
	
	
	//get:- getPropertyPGByAvailableFor(“/property/agent/pg/bg/{availableFor}”)
	@GetMapping("/property/agent/pg/bg/{availableFor}")
	public List<FavoritePropertiesPG> getPropertyPGByAvailableFor(
			@PathVariable String availableFor)
	{
		List<FavoritePropertiesPG> list=favoritePropertiesPGServicei.getPropertyPGByAvailableFor(availableFor);
		return list;
	}
	
//	@GetMapping("/properties/users/filters/pg/{locality}/{onePersonRent}/{availableFor}/{foodAvailability}/{acRoomsAvailability}/{powerBackup}")
//	public ResponseEntity<List<FavoritePropertiesPG>> getFilteredPGProperties(
//			@PathVariable(required = false) String locality,
//			@PathVariable(required = false) int onePersonRent,
//			@PathVariable(required = false) String availableFor,
//			@PathVariable(required = false) String foodAvailability,
//			@PathVariable(required = false) String acRoomsAvailability,
//			@PathVariable(required = false) String powerBackup)
//	{
//		List<FavoritePropertiesPG> list=favoritePropertiesPGServicei.getFilteredPGProperties(locality, onePersonRent, availableFor, foodAvailability, acRoomsAvailability, powerBackup);
//		return new ResponseEntity<List<FavoritePropertiesPG>>(list, HttpStatus.OK);
//	}
	
}
