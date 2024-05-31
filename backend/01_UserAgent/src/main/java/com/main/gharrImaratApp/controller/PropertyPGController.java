package com.main.gharrImaratApp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.PropertyPG;
import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.model.UserAgent;
import com.main.gharrImaratApp.service.PropertyPGServiceInterface;

@RestController
@CrossOrigin("*")
public class PropertyPGController {

	@Autowired PropertyPGServiceInterface propertyPGServiceInterface;
	
//	@PutMapping("/properties/agent/pg/{userAgent1ID}/{userAgent2ID}")
//	public ResponseEntity<UserAgent> updatePropertyPG(@PathVariable UUID userAgent1ID, 
//			                                          @PathVariable UUID userAgent2ID, 
//			                                          @RequestPart("text") String text,
//			                                          @RequestPart("images") MultipartFile[] images)
//	{
//		UserAgent userAgent=propertyPGServiceInterface.updatePropertyPG(userAgent1ID, userAgent2ID, text, images);
//		return new ResponseEntity<UserAgent>(userAgent, HttpStatus.CREATED);
//		
//	}
	
	@PutMapping("/properties/agent/pg/{userAgent1ID}/{userAgent2ID}")
	public ResponseEntity<UserAgent> updatePropertyPG(@PathVariable UUID userAgent1ID, 
			                                          @PathVariable UUID userAgent2ID,
			                                         @RequestBody PropertyPG propertyPG	)
	{
		UserAgent userAgent=propertyPGServiceInterface.updatePropertyPG(userAgent1ID, userAgent2ID, propertyPG);
		return new ResponseEntity<UserAgent>(userAgent, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/properties/agent/pg/getall/{userAgent1ID}/{userAgent2ID}")
	public ResponseEntity<List<PropertyPG>> getAllPRopertyPG(@PathVariable UUID userAgent1ID,@PathVariable UUID userAgent2ID)
	{
		List<PropertyPG> propertyPGList = propertyPGServiceInterface.getAllPropPG(userAgent1ID,userAgent2ID);
		return new ResponseEntity<List<PropertyPG>>(propertyPGList, HttpStatus.OK);
	}
	
	
	@PutMapping("/properties/agent/pg/sharing/{propertyPGID}")
	public ResponseEntity<PropertyPG> updateSharingRoomsPG(@PathVariable UUID propertyPGID, 		 
			                                          @RequestPart("text") String text,
			                                          @RequestPart("images") MultipartFile[] images)
	{
		PropertyPG propertyPG=propertyPGServiceInterface.updateSharingRoomsPG(propertyPGID, text, images);
		return new ResponseEntity<PropertyPG>(propertyPG, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/properties/agent/pg/{propertyPGID}")
	public ResponseEntity<Optional<PropertyPG>>  getPropertyPG(@PathVariable UUID propertyPGID)
	{
		Optional<PropertyPG> propertyPgId=propertyPGServiceInterface.getPropertyPG(propertyPGID);
		return new ResponseEntity<Optional<PropertyPG>>(propertyPgId, HttpStatus.OK);
		
	}
	
	@GetMapping("/property/agent/pg/beds/{totalNoOfBeds}")
	public ResponseEntity<List<PropertyPG>> getPropertyPGByNoOfBedsAvailable(@PathVariable String totalNoOfBeds)
	{
		List<PropertyPG>  getPropertyTotalNoOfBeds=propertyPGServiceInterface.getPropertyPGByNoOfBedsAvailable(totalNoOfBeds);
		return new ResponseEntity<List<PropertyPG>>(getPropertyTotalNoOfBeds, HttpStatus.OK);
		
	}
	
	@GetMapping("/property/agent/pg/bg/{availableFor}")
	public ResponseEntity<List<PropertyPG>> getPropertyPGByAvailableFor(@PathVariable String availableFor)
	{
		List<PropertyPG> pgAvailableFor=propertyPGServiceInterface.getPropertyPGByAvailableFor(availableFor);
		return new ResponseEntity<List<PropertyPG>>(pgAvailableFor, HttpStatus.OK);
	}
	
	@GetMapping("/properties/agent/filters/pg/{locality}/{onePersonRent}/{availableFor}/{foodAvailability}/{acRoomsAvailability}/{powerBackup}")
	public List<PropertyPG> getFilteredProperties(
																									@PathVariable(required = false) String locality,
																								    @PathVariable(required = false) int onePersonRent,
																								    @PathVariable(required = false) String availableFor,
																								    @PathVariable(required = false) String foodAvailability,
																								    @PathVariable(required = false) String acRoomsAvailability,
																								    @PathVariable(required = false) String powerBackup																			   
	) {
	    // Call the service method with the provided filters
	    List<PropertyPG> list = propertyPGServiceInterface.getFilteredProperties(locality,onePersonRent,availableFor,foodAvailability,acRoomsAvailability,powerBackup);
//	    System.out.println(list);
	    return list;
	}
	
//get by location, available for /<price
	@GetMapping("/property/agent/pg/LAR/{locality}/{availableFor}/{onePersonRent}")
	public ResponseEntity<List<PropertyPG>> getPropertyPGByLAR(@PathVariable String locality,
																													@PathVariable String availableFor,
																													@PathVariable int onePersonRent)
	{
		List<PropertyPG> pgAvailableFor=propertyPGServiceInterface.getPropertyPGByLAR(locality,availableFor,onePersonRent);
		System.out.println(pgAvailableFor.size());
		return new ResponseEntity<List<PropertyPG>>(pgAvailableFor, HttpStatus.OK);
	}
	
	@GetMapping("/properties/agent/filters/pg/sr/{propertyPGID}/{sharing}/{availableFor}")
	public List<SharingRooms> getFilteredProperties(						
																									@PathVariable(required = false) String sharing,
																								    @PathVariable(required = false) String availableFor,
																								    @PathVariable(required = false) UUID propertyPGID
																								    																			   
	) {
	    // Call the service method with the provided filters
	    List<SharingRooms> list = propertyPGServiceInterface.getFilteredRoomsBySA (propertyPGID,sharing,availableFor);
//	    System.out.println(list);
	    return list;
	}
	
}
