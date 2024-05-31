package com.main.gharrImaratApp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.UserBuyer;
import com.main.gharrImaratApp.repository.UserBuyerRepository;
import com.main.gharrImaratApp.servicei.FavoritePropertiesRentAndBuyService;

@RestController
@CrossOrigin("*")
public class FavoritePropertiesRentAndBuyController {
	
	@Autowired FavoritePropertiesRentAndBuyService favoritePropertiesRentAndBuyService;

	//put:- updatePropertyByRentAndBuy(“/properties/buyer/rb/{userBuyer1ID}/{userBuyer2ID}”)
	
	@PutMapping("/properties/buyer/rentbuy/{userBuyer1ID}/{userBuyer2ID}")
	public ResponseEntity<UserBuyer> addPropertyRentANdBuyToUserBuyer(
			@PathVariable UUID userBuyer1ID, @PathVariable UUID userBuyer2ID,@RequestBody FavoritePropertiesRentAndBuy favoritePropertiesRentAndBuy)
	{
		UserBuyer userBuyer=favoritePropertiesRentAndBuyService.addPropertyRentANdBuyToUserBuyer(userBuyer1ID, userBuyer2ID,favoritePropertiesRentAndBuy);
		return new ResponseEntity<UserBuyer>(userBuyer, HttpStatus.CREATED);
	}
//	@PutMapping("/properties/buyer/rentbuy/{userBuyer1ID}/{userBuyer2ID}")
//	public ResponseEntity<UserBuyer> addPropertyRentANdBuyToUserBuyer(
//			@PathVariable UUID userBuyer1ID, @PathVariable UUID userBuyer2ID,
//			@RequestPart("text") String text,
//			@RequestPart("image") MultipartFile[] image)
//	{
//		UserBuyer userBuyer=favoritePropertiesRentAndBuyService.addPropertyRentANdBuyToUserBuyer(userBuyer1ID, userBuyer2ID, text, image);
//	
//		return new ResponseEntity<UserBuyer>(userBuyer, HttpStatus.CREATED);
//	}
	
	//get:- getPropertyByRentAndBuy(“/properties/buyer/rb/{userBuyer1ID}/{userBuyer2ID}”)
	@GetMapping("/properties/buyer/rb/getall/{userBuyer1ID}/{userBuyer2ID}")
	public List<FavoritePropertiesRentAndBuy>  getFavoritePropertyAndBuys(
			@PathVariable UUID userBuyer1ID, @PathVariable UUID userBuyer2ID)
	{
	
		List<FavoritePropertiesRentAndBuy> list=favoritePropertiesRentAndBuyService.getPropertyByRentAndBuy(userBuyer1ID, userBuyer2ID);
		return list;
	}
	
	@GetMapping("/properties/buyer/rb/fav/{userBuyer1ID}/{userBuyer2ID}/{propertyRBIDSave}")
	public FavoritePropertiesRentAndBuy  getFavoritePropertyAndBuysByPropRBID(
			@PathVariable UUID userBuyer1ID, @PathVariable UUID userBuyer2ID, @PathVariable UUID propertyRBIDSave)
	{
	
		
		FavoritePropertiesRentAndBuy prop=favoritePropertiesRentAndBuyService.getPropertyByRentAndBuyByPropID(userBuyer1ID, userBuyer2ID,propertyRBIDSave);
		System.out.println(prop);
		return prop;
	}
	@DeleteMapping("properties/buyer/rb/del/{userBuyer1ID}/{userBuyer2ID}/{propertyRBID}")
	public ResponseEntity<FavoritePropertiesRentAndBuy> deletePropertyRB(@PathVariable UUID userBuyer1ID, @PathVariable UUID userBuyer2ID,@PathVariable UUID propertyRBID)
	{
		System.out.println(userBuyer1ID);
		System.out.println(userBuyer2ID);
		System.out.println(propertyRBID);
	FavoritePropertiesRentAndBuy propRB=	favoritePropertiesRentAndBuyService.deleteProperty(userBuyer1ID,userBuyer2ID,propertyRBID);
		return new  ResponseEntity<FavoritePropertiesRentAndBuy>(propRB,HttpStatus.OK);
	}
	//for Filters
	

//		@GetMapping("/properties/users/filters/{propertyLocality}/{price}/{propertyType}/{furnishing}/{facing}/{constructionPhase}/{flatBHK}")
//		public ResponseEntity<List<FavoritePropertiesRentAndBuy>> getFilteredProperties
//		(
//		@PathVariable(required = false) String propertyLocality,
//		@PathVariable(required = false) int price,
//		@PathVariable(required = false) String propertyType,
//		@PathVariable(required = false) String furnishing,
//		@PathVariable(required = false) String facing,
//		@PathVariable(required = false) String constructionPhase,
//		@PathVariable(required = false) String flatBHK
//		) {
//		    // Call the service method with the provided filters
//		    List<FavoritePropertiesRentAndBuy> list = favoritePropertiesRentAndBuyService.getFilteredProperties(propertyLocality,price,propertyType,furnishing,facing,constructionPhase,flatBHK);
////		    System.out.println(list);
//		    return new ResponseEntity<List<FavoritePropertiesRentAndBuy>>(list, HttpStatus.OK);
//		}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
