package com.main.gharrImaratApp.controller;

import java.util.List;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.FavoritePropertiesPG;
import com.main.gharrImaratApp.model.PropertyReview;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.servicei.SharingRoomsService;

@RestController
public class SharingRoomsController {

	@Autowired SharingRoomsService sharingRoomsService;
	
	// put:- updateSharingRoomsPG(“/properties/buyer/pg/sharing/(propertyPGID))
		@PutMapping("/properties/buyer/pg/sharing/{propertyPGID}")
		public ResponseEntity<FavoritePropertiesPG> updateSharingRoomsPG(
				@PathVariable UUID propertyPGID,
				@RequestPart("text") String text,
				@RequestPart("images")MultipartFile[] images)
		{
			FavoritePropertiesPG favoritePropertiesPG=sharingRoomsService.updateSharingRoomsPG(propertyPGID, text, images);
			return new ResponseEntity<FavoritePropertiesPG>(favoritePropertiesPG, HttpStatus.CREATED);
		}
		
		
	 //put:- updateSharingRoomsReviewsPG(“/sharingrooms/user/pg/{roomPGID}”)
	 @PutMapping("/sharingrooms/user/pg/review/{roomPGID}")
	 public ResponseEntity<SharingRooms> updateSharingRoomsReviewsPG(@PathVariable UUID roomPGID,
				@RequestBody PropertyReview propertyReview)
		{
			SharingRooms sharingRoomsReveiws=sharingRoomsService.updateSharingRoomsReviewsPG(roomPGID,propertyReview);
			return new ResponseEntity<SharingRooms>(sharingRoomsReveiws,HttpStatus.OK);
		}
	 
	 //getSharingRoomsByLocationPriceBudget(“/sharingrooms/user/pg/LPB/{”location”}/{”availableFor”}/{”rent”})
	 @GetMapping("/sharingrooms/user/pg/LPB/{location}/{availableFor}/{rent}")
	 public ResponseEntity<List<SharingRooms>> getSharingRoomsByLocationPriceBudget(
			@PathVariable String location,
			@PathVariable String availableFor,
			@PathVariable String rent)
	 {
		 List<SharingRooms> list = sharingRoomsService.getSharingRoomsByLocationPriceBudget(location,availableFor, rent);
		 return new ResponseEntity<List<SharingRooms>>(list, HttpStatus.OK);
	 }
	
	 //get:- getPropertySharingRoomsBySharing(“/sharingrooms/user/pg/sharing/{sharing}”)
	 @GetMapping("/sharingrooms/user/pg/sharing/{sharing}")
	 public ResponseEntity<List<SharingRooms>> getPropertySharingRoomsBySharing(
			 @PathVariable String sharing)
	 {
		 List<SharingRooms> list = sharingRoomsService.getPropertySharingRoomsBySharing(sharing);
		 return new ResponseEntity<List<SharingRooms>>(list, HttpStatus.OK);
	 }
	 
	 // get:- getPropertySharingRoomsByRent(“/sharingrooms/user/pg/rent/{rent}”)
	 @GetMapping("/sharingrooms/user/pg/rent/{rent}")
	 public ResponseEntity<List<SharingRooms>> getPropertySharingRoomsByRent(
			 @PathVariable int rent)
	 {
		 List<SharingRooms> list=sharingRoomsService.getPropertySharingRoomsByRent(rent);
		 return new ResponseEntity<List<SharingRooms>>(list, HttpStatus.OK);
	 }
	 
	 // get:- getPropertySharingRoomsByFooDAailablity(“/sharingrooms/user/pg/rent/{foodAvailability}”)
	 @GetMapping("/sharingrooms/users/pg/rent/{foodAvailability}")
	 public ResponseEntity<List<SharingRooms>> getPropertySharingRoomsByFooDAailablity(
			 @PathVariable String foodAvailability)
	 {
		 List<SharingRooms>list=sharingRoomsService.getPropertySharingRoomsByFooDAailablity(foodAvailability);
		 return new ResponseEntity<List<SharingRooms>>(list, HttpStatus.OK);
	 }
}
