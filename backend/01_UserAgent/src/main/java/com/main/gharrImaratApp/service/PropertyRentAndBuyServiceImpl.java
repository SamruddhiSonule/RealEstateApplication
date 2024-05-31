package com.main.gharrImaratApp.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.gharrImaratApp.model.PropertyImages;
import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.UserAgent;
import com.main.gharrImaratApp.repository.PropertyRentAndBuyRepository;
import com.main.gharrImaratApp.repository.UserAgentRepository;

@Service
public class PropertyRentAndBuyServiceImpl implements PropertyRentAndBuyServiceInterface{

	@Autowired PropertyRentAndBuyRepository propertyRentAndBuyRepository;
	@Autowired UserAgentRepository userAgentRepository;
	

	@Override
	public UserAgent  addpropertyRentAndBuyRecord(UUID userAgent1ID, UUID userAgent2ID, String text, MultipartFile[] image) {
	    // Save property details
		Optional<UserAgent> userAgent=userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
	    UserAgent userAgents=userAgent.get();
		if(userAgent.isPresent()) {
			ObjectMapper mapper=new ObjectMapper();
		    
		    try {
				PropertyRentAndBuy propertyRentAndBuy=mapper.readValue(text, PropertyRentAndBuy.class);
				
				if(image !=null) {
					List<PropertyImages> propertyImagesList = new ArrayList<>();
					for (MultipartFile images : image) {
		                // Process each image
		                PropertyImages propertyImage = new PropertyImages();
		                propertyImage.setImage(images.getBytes()); // Assuming PropertyImages class has a setImage(byte[]) method
		                propertyImagesList.add(propertyImage);
		            }
					propertyRentAndBuy.getPropertyImages().addAll(propertyImagesList);
					
					LocalTime localTime=LocalTime.now();
					LocalDate localDate=LocalDate.now();
					String localTme=localTime.toString();
					String localDte=localDate.toString();
					propertyRentAndBuy.setLocalTime(localTme);
					propertyRentAndBuy.setLocalDate(localDte);
					propertyRentAndBuy.setUserAgent1ID(userAgent1ID);
					propertyRentAndBuy.setUserAgent2ID(userAgent2ID);
					userAgents.getPropertyRentAndBuyList().add(propertyRentAndBuy); // agent adds list of properties
					return userAgentRepository.save(userAgents);
				}
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			throw new NoSuchElementException("Data not found for provided UUIDs");
		}
		return null;
	    
	}



	@Override
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByLocationFlatBHKPrice(String location, String flatBHK,
			int price, String forSaleOrRentString) {
		List<PropertyRentAndBuy> list=propertyRentAndBuyRepository.findByLocationAndFlatBHKAndPriceLessThan(location,flatBHK,price,forSaleOrRentString);
		return list;
	}



	@Override
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByPrice(int price) {
		List<PropertyRentAndBuy> getlessThanPrice=propertyRentAndBuyRepository.findByPriceLessThan(price);
		return getlessThanPrice;
	}



	@Override
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByPropertyType(String propertyTYPE) {
		List<PropertyRentAndBuy> getPropertyByType=propertyRentAndBuyRepository.findByPropertyType(propertyTYPE);
		return getPropertyByType;
	}



	@Override
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByFurnishing(String furnishing) {
		List<PropertyRentAndBuy>  getFurnishing=propertyRentAndBuyRepository.findByFurnishing(furnishing);
		return getFurnishing;
	}



	@Override
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByNoOfBathrooms(int numberOfBathroom) {
		List<PropertyRentAndBuy>   getNumberOfBathroom=propertyRentAndBuyRepository.findByNumberOfBathroom(numberOfBathroom);
		return getNumberOfBathroom;
	}



	@Override
	public List<PropertyRentAndBuy> getPropertyByRentAndBuy(UUID userAgent1ID, UUID userAgent2ID) {
		List<PropertyRentAndBuy> list=userAgentRepository.findPropertyRentAndBuyByUserAgent(userAgent1ID, userAgent2ID);
		return list;
	}



	@Override
	public List<PropertyRentAndBuy> getPropertyByRentAndBuyBypropertyLocality(String propertyLocality) {
		List<PropertyRentAndBuy> list=propertyRentAndBuyRepository.findByPropertyLocality(propertyLocality);
		return list;
	}



	@Override
	public List<PropertyRentAndBuy> getFilteredProperties(String propertyLocality, int price, String propertyType,
			String furnishing, String forSaleOrRentString, String facing, String constructionPhase, String flatBHK) {
		System.out.println("Property Locality: "+propertyLocality);
		System.out.println("Price: "+price);
		System.out.println("PropertyType: "+propertyType);
		System.out.println("Furnishing: "+furnishing);
		System.out.println("For sale: "+forSaleOrRentString);
		System.out.println("Facing: "+facing);
		System.out.println("Cnst Pahse: "+constructionPhase);
		System.out.println("Flat BHK: "+flatBHK);
	
//	List<PropertyRentAndBuy> list=	propertyRentAndBuyRepository.findByFilters(propertyLocality,price,propertyType,furnishing,forSaleOrRentString,facing,constructionPhase,flatBHK);
		 List<PropertyRentAndBuy> list=	propertyRentAndBuyRepository.findAll();
		     Stream<PropertyRentAndBuy> stream = list.stream();
		   if(!propertyLocality.equals(null))
		   {
			   System.out.println("check locality");
			   stream=   stream.filter(prop->(prop.getPropertyLocality().equals(propertyLocality)));
		   }
		   if(price > 0)
		   {
			   System.out.println("check price");
			   stream=   stream.filter(prop->prop.getPrice()<=price);
		   }
		   if(!propertyType.equals("null"))
		   {
			   System.out.println((propertyType.length()>0));
			   System.out.println("check Property Type");
			   stream=stream.filter(prop->prop.getPropertyTYPE().equals(propertyType));   
		   }
		   if(!furnishing.equals("null"))
		   {
			   System.out.println("check furnishing");
			   stream=stream.filter(prop->prop.getFurnishing().equals(furnishing));
		   }
		   if(!forSaleOrRentString .equals("null"))
		   {
			   System.out.println("check sale Or rent");
			   stream=stream.filter(prop->prop.getForSaleOrRentString().equals(forSaleOrRentString));
		   }
		   if(!facing .equals("null"))
		   {
			   System.out.println("check facing");
			   stream=stream.filter(prop->prop.getFacing().equals(facing));
		   }
		   if(!constructionPhase .equals("null"))
		   {
			   System.out.println("check constr. phase");
			   stream=stream.filter(prop->prop.getConstructionPhase().equals(constructionPhase));
		   }
		   if(!flatBHK .equals("null"))
		   {
			   System.out.println("check flatbhk");
			   stream=stream.filter(prop->prop.getFlatBHK().equals(flatBHK));
		   }
		   List<PropertyRentAndBuy> list1=stream.collect(Collectors.toList());;
		
		return list1;
		
//  	  List<PropertyRentAndBuy> result = stream.filter(property ->  {
//  		return( (propertyLocality!=null)? (property.getPropertyLocality()==propertyLocality):(false) &&
//  				    (price>0)?(property.getPrice()<price):(false) &&
//			    		(propertyType!=null));
//  				  
//  	  } 
//	    			  ).collect(Collectors.toList());
	}



	@Override
	public List<PropertyRentAndBuy> getAllProperTyRentAndBuy() {
 List<PropertyRentAndBuy> list=	propertyRentAndBuyRepository.findAll();
		return list;
	}






	


}
