package com.main.gharrImaratApp.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.UserAgent;
import com.main.gharrImaratApp.service.PropertyRentAndBuyServiceInterface;
import com.main.gharrImaratApp.service.UserAgentServiceInterface;

@RestController
@CrossOrigin("*")
public class PropertyRentAndBuyController {

	@Autowired PropertyRentAndBuyServiceInterface propertyRentAndBuyServiceInterface;
	
	@Autowired UserAgentServiceInterface userAgentServiceInterface;
	
	@PutMapping("/properties/agent/{userAgent1ID}/{userAgent2ID}")
	public ResponseEntity<UserAgent> updatePropertyByRentAndBuy(@PathVariable UUID userAgent1ID, @PathVariable UUID userAgent2ID,@RequestPart("text") String text,			    
	                                             @RequestPart("image") MultipartFile[] image) {
		 
		UserAgent userAgent =propertyRentAndBuyServiceInterface.addpropertyRentAndBuyRecord(userAgent1ID, userAgent2ID, text, image);

	    return new ResponseEntity<UserAgent>(userAgent, HttpStatus.CREATED);
	}// add properties using agent ID's
	
	
    @RequestMapping("/properties/agent/{userAgent1ID}/{userAgent2ID}")
	public List<PropertyRentAndBuy>  getPropertyByRentAndBuy(@PathVariable UUID userAgent1ID, @PathVariable UUID userAgent2ID)	{

    	List<PropertyRentAndBuy> list=propertyRentAndBuyServiceInterface.getPropertyByRentAndBuy(userAgent1ID, userAgent2ID);
	         
			return list;
	       // find the  property through the agent ID' s
		     
	}
	
  //get all propertyRB
    @GetMapping("/properties/agent/getall")
    public ResponseEntity<List<PropertyRentAndBuy>> getAllPropRB()
    {
     List<PropertyRentAndBuy> list=	propertyRentAndBuyServiceInterface.getAllProperTyRentAndBuy();
    	return new ResponseEntity<List<PropertyRentAndBuy>>(list,HttpStatus.OK);
    }//
    
	@GetMapping("/properties/agent/location/{location}/{flatBHK}/{price}/{forSaleOrRentString}")
	public ResponseEntity<List<PropertyRentAndBuy>> getPropertyByRentAndBuyByLocationFlatBHKPrice(@PathVariable String location,
			@PathVariable String flatBHK, 
			@PathVariable int price,
			@PathVariable String forSaleOrRentString)
	{System.out.println(location);
	System.out.println(flatBHK);
	System.out.println(price);
	System.out.println(forSaleOrRentString);
		List<PropertyRentAndBuy> list=propertyRentAndBuyServiceInterface.getPropertyByRentAndBuyByLocationFlatBHKPrice(location,flatBHK,price,forSaleOrRentString);
		
		return new ResponseEntity<List<PropertyRentAndBuy>>(list,HttpStatus.OK);
	}// search properties using location, bhk and price
	
	@GetMapping("/properties/agent/price/{price}")
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByPrice(@PathVariable int price)
	{
		List<PropertyRentAndBuy> getPropertyLessPrice=propertyRentAndBuyServiceInterface.getPropertyByRentAndBuyByPrice(price);
		return getPropertyLessPrice;
	}// search Property Less than price
	
	
	@GetMapping("/properties/agent/propertyType/{propertyTYPE}")
	public  List<PropertyRentAndBuy> getPropertyByRentAndBuyByPropertyType(@PathVariable String propertyTYPE)
	{
		List<PropertyRentAndBuy> propertyType=propertyRentAndBuyServiceInterface.getPropertyByRentAndBuyByPropertyType(propertyTYPE);
		return propertyType;
		
	} // get By Property Type
	
	@GetMapping("/properties/agent/furnishing/{furnishing}")
	public List<PropertyRentAndBuy>  getPropertyByRentAndBuyByFurnishing(@PathVariable String furnishing)
	{
		List<PropertyRentAndBuy>  getFurnishing=propertyRentAndBuyServiceInterface.getPropertyByRentAndBuyByFurnishing(furnishing);
		return getFurnishing; 
		
	}// get Furnishing
	
	
	@GetMapping("/properties/agent/bathroom/{numberOfBathroom}")
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByNoOfBathrooms(@PathVariable int numberOfBathroom)
	{
		List<PropertyRentAndBuy> getnumberOfBathroom=propertyRentAndBuyServiceInterface.getPropertyByRentAndBuyByNoOfBathrooms(numberOfBathroom);
		return getnumberOfBathroom;
		
	}
	
	@GetMapping("/properties/agent/locality/{propertyLocality}")
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyBypropertyLocality(@PathVariable String propertyLocality)
	{
		List<PropertyRentAndBuy> getPropertyLocality=propertyRentAndBuyServiceInterface.getPropertyByRentAndBuyBypropertyLocality(propertyLocality);
		return getPropertyLocality;
	}
	 
//for Filters
	

	@GetMapping("/properties/agent/filters/{propertyLocality}/{price}/{propertyType}/{furnishing}/{forSaleOrRentString}/{facing}/{constructionPhase}/{flatBHK}")
	public List<PropertyRentAndBuy> getFilteredProperties(
																									@PathVariable(required = false) String propertyLocality,
																								    @PathVariable(required = false) int price,
																								    @PathVariable(required = false) String propertyType,
																								    @PathVariable(required = false) String furnishing,
																								    @PathVariable(required = false) String forSaleOrRentString,
																								    @PathVariable(required = false) String facing,
																								    @PathVariable(required = false) String constructionPhase,
																								    @PathVariable(required = false) String flatBHK
	) {
	    // Call the service method with the provided filters
	    List<PropertyRentAndBuy> list = propertyRentAndBuyServiceInterface.getFilteredProperties(propertyLocality,price,propertyType,furnishing,forSaleOrRentString,facing,constructionPhase,flatBHK);
//	    System.out.println(list);
	    return list;
	}

	
}
