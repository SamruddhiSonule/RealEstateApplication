package com.main.gharrImaratApp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.PropertyPG;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.service.SharingRoomServiceInterface;

@RestController
@CrossOrigin("*")
public class SharingRoomController {

	@Autowired SharingRoomServiceInterface sharingRoomServiceInterface;
	
	@PutMapping("/sharingrooms/agent/pg/{propertyPGID}")
	public ResponseEntity<PropertyPG> updateSharingRoomsPG(@PathVariable UUID propertyPGID,
			                                               @RequestPart("text") String text,
			                                               @RequestPart("images") MultipartFile[] images)
	{
		PropertyPG updatesharingRooms=sharingRoomServiceInterface.updateSharingRoomsPG(propertyPGID, text, images);
		return new ResponseEntity<PropertyPG>(updatesharingRooms, HttpStatus.CREATED);
		
	}
//get all	
	@GetMapping("/sharingrooms/agent/pg/sharing/getall/{propertyPGID}")
	public ResponseEntity<List<SharingRooms>> getAllPropertySharingRoomsByPID(@PathVariable UUID propertyPGID)
	{
		System.out.println("get all Sharing rooms by ID");
		List<SharingRooms> getSharingRoom=sharingRoomServiceInterface.getAllPropertySharingRoomsByPI(propertyPGID);
		return new ResponseEntity<List<SharingRooms>>(getSharingRoom, HttpStatus.OK);
		
	}
	
	@PutMapping("/sharingrooms/agent/pg/{roomPGID}")
	public ResponseEntity<SharingRooms> updateSharingRoomsReviewsPG(@PathVariable UUID roomPGID,
			                                                       @RequestPart("text") String text,
                                                                   @RequestPart("images") MultipartFile[] images)
	{
		SharingRooms updateSharingRooms=sharingRoomServiceInterface.updateSharingRoomsReviewsPG(roomPGID, text, images);
		
		return new ResponseEntity<SharingRooms>(updateSharingRooms, HttpStatus.CREATED);
		
	}
	
//	get:-
//	getSharingRoomsByLocationPriceBudget(“/sharingrooms/agent/pg/LPB/{”location”}/{”availableFor”}
//	/{”rent”})
	public ResponseEntity<List<SharingRooms>> getSharingRoomsByLocationPriceBudget(@PathVariable String location, 
			@PathVariable String availableFor, @PathVariable int rent)
	{
		List<SharingRooms> getLocationRentandAvailableFor=sharingRoomServiceInterface.getSharingRoomsByLocationPriceBudget(location, availableFor, rent);
		return new ResponseEntity<List<SharingRooms>>(getLocationRentandAvailableFor, HttpStatus.OK);
		
	}


	@GetMapping("/sharingrooms/agent/pg/sharing/{sharing}")
	public ResponseEntity<List<SharingRooms>> getPropertySharingRoomsBySharing(@PathVariable String sharing)
	{
		List<SharingRooms> getSharingRoom=sharingRoomServiceInterface.getPropertySharingRoomsBySharing(sharing);
		return new ResponseEntity<List<SharingRooms>>(getSharingRoom, HttpStatus.OK);
		
	}
   
	@GetMapping("/sharingrooms/agent/pg/rent/{rent}")
	public ResponseEntity<List<SharingRooms>> getPropertySharingRoomsByRent(@PathVariable int rent)
	{
		List<SharingRooms> getPGbyRent=sharingRoomServiceInterface.getPropertySharingRoomsByRent(rent);
		return new ResponseEntity<List<SharingRooms>>(getPGbyRent, HttpStatus.OK);
		
	}
	
	@GetMapping("/sharingrooms/agent/pg/rent/{foodAvailability}")
    public ResponseEntity<List<SharingRooms>> getPropertySharingRoomsByFooDAailablity(@PathVariable String foodAvailability)
    {
		List<SharingRooms> getoodAvailability=sharingRoomServiceInterface.getPropertySharingRoomsByFooDAailablity(foodAvailability);
		return new ResponseEntity<List<SharingRooms>>(getoodAvailability, HttpStatus.OK);
    	
    }
	
//	get:- getPropertySharingRoomsByFooDAailablity(“/sharingrooms/agent/pg/rent/{foodAvailability}”)
}
