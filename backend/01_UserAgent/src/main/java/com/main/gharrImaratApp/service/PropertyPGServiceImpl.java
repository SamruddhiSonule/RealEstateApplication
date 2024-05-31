package com.main.gharrImaratApp.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.gharrImaratApp.model.PropertyImages;
import com.main.gharrImaratApp.model.PropertyPG;
import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.model.UserAgent;
import com.main.gharrImaratApp.repository.PropertyPGRepository;
import com.main.gharrImaratApp.repository.UserAgentRepository;

@Service
public class PropertyPGServiceImpl implements PropertyPGServiceInterface{

	@Autowired UserAgentRepository userAgentRepository;
	
	@Autowired PropertyPGRepository propertyPGRepository;
	

	@Override
	public UserAgent updatePropertyPG(UUID userAgent1ID, UUID userAgent2ID , PropertyPG propertyPG ) {
	    Optional<UserAgent> optionalUserAgent = userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
	    if (optionalUserAgent.isPresent()) {
	        UserAgent userAgent = optionalUserAgent.get();
	        LocalTime localTime=LocalTime.now();
			LocalDate localDate=LocalDate.now();
			String localTme=localTime.toString();
			String localDte=localDate.toString();
	        userAgent.getPropertyPGList().add(propertyPG);
	        propertyPG.setLocalTime(localTme);
	        propertyPG.setLocalDate(localDte);
	        propertyPG.setUserAgent1ID(userAgent1ID);
	        propertyPG.setUserAgent2ID(userAgent2ID);
	        // Save the updated UserAgent
	        UserAgent updatedUserAgent = userAgentRepository.save(userAgent);
	        
	        return updatedUserAgent;
	    } else {
	        return null; // Indicate that the User
	    }
	}


	@Override
	public PropertyPG updateSharingRoomsPG(UUID propertyPGID, String text, MultipartFile[] images) {
		Optional<PropertyPG> propertyPg=propertyPGRepository.findByPropertyPGID(propertyPGID);
		
		if(propertyPg.isPresent()) {
			PropertyPG property=propertyPg.get();
			
			ObjectMapper mapper=new ObjectMapper();
			
			try {
				SharingRooms sharingRoom=mapper.readValue(text, SharingRooms.class);
				
				if(images!=null)
				{
					List<PropertyImages> propertyImagesList = new ArrayList<>();
					for (MultipartFile img : images) {
		                // Process each image
		                PropertyImages propertyImage = new PropertyImages();
		                propertyImage.setImage(img.getBytes()); // Assuming PropertyImages class has a setImage(byte[]) method
		                propertyImagesList.add(propertyImage);
		            }
					sharingRoom.getPropertyImages().addAll(propertyImagesList);
					
					property.getSharingRooms().add(sharingRoom);
					
					return propertyPGRepository.save(property);
					
				}
								
			} catch (JsonProcessingException e) {		
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		return null;
	}


	@Override
	public Optional<PropertyPG> getPropertyPG(UUID propertyPGID) {
		Optional<PropertyPG> propertyPg=propertyPGRepository.findByPropertyPGID(propertyPGID);
		return propertyPg;
	}


	@Override
	public List<PropertyPG> getPropertyPGByNoOfBedsAvailable(String totalNoOfBeds) {
		List<PropertyPG> getNoOfBeds=propertyPGRepository.findByTotalNoOfBeds(totalNoOfBeds);  // When we use optional native query is return only single result
		                                                                                           // Thats why we use list
		return getNoOfBeds;
	}


	@Override
	public List<PropertyPG> getPropertyPGByAvailableFor(String availableFor) {
		 List<PropertyPG> getPgAvailableFor=propertyPGRepository.findByAvailableFor(availableFor);
		return getPgAvailableFor;
	}


	@Override
	public List<PropertyPG> getAllPropPG(UUID userAgent1ID,UUID userAgent2ID) {
		Optional<UserAgent> usOptional =userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
		
		if (usOptional.isPresent()) {
		UserAgent userAgent=	usOptional.get();
		
	List<PropertyPG> propertyPG=	userAgent.getPropertyPGList();
	System.out.println(propertyPG);
		return propertyPG;
		}
		return null;
	}


	@Override
	public List<PropertyPG> getFilteredProperties(String locality, int onePersonRent, String availableFor,
			String foodAvailability, String acRoomsAvailability, String powerBackup) {
	 List<PropertyPG> list = propertyPGRepository.findAll();
	 
	 Stream<PropertyPG> stream = list.stream();
	 
	  if(!locality.equals("null"))
	   {
		   System.out.println("check locality");
		   stream=   stream.filter(prop->(prop.getLocality().equals(locality)));
	   }
	  
	  if(onePersonRent>0)
	   {
		   System.out.println("check rent");
		   stream=   stream.filter(prop->(prop.getOnePersonRent()<=onePersonRent));
	   }
	  if(!availableFor.equals("null"))
	   {
		   System.out.println("check available for");
		   stream=   stream.filter(prop->(prop.getAvailableFor().equals(availableFor)));
	   }
	  if(!foodAvailability.equals("null"))
	   {
		   System.out.println("check Food available ");
		   stream=   stream.filter(prop->(prop.getFoodAvailability().equals(foodAvailability)));
	   }
	  if(!acRoomsAvailability.equals("null"))
	   {
		   System.out.println("check Ac Rooms available ");
		   stream=   stream.filter(prop->(prop.getAcRoomsAvailability().equals(acRoomsAvailability)));
	   }
	  if(!powerBackup.equals("null"))
	   {
		   System.out.println("check PowerBackup");
		  stream=stream.filter(prop->(prop.getPowerBackup().equals(powerBackup)));
	   }
		return stream.collect(Collectors.toList());
	}


	@Override
	public List<PropertyPG> getPropertyPGByLAR(String locality, String availableFor, int onePersonRent) {
		 List<PropertyPG> list= propertyPGRepository.findLocalityAvailableForRent(locality,availableFor,onePersonRent);
		return list;
	}


	@Override
	public List<SharingRooms> getFilteredRoomsBySA(UUID propertyPGID, String sharing, String availableFor) {
	 Optional<PropertyPG> prOptional=	propertyPGRepository.findById(propertyPGID);
	 if (prOptional.isPresent()) {
	PropertyPG pg=	prOptional.get();
	
	List<SharingRooms> list = pg.getSharingRooms();
	Stream<SharingRooms> stream = list.stream();
	
	if(!sharing.equals("null"))
	{
		stream=stream.filter(prop->(prop.getSharing().equals(sharing)));
	}
	if(!availableFor.equals("null"))
	{
		stream=stream.filter(prop->(prop.getAvailableFor().equals(availableFor)));
	}
		return stream.collect(Collectors.toList());
	}//
		return null ;
	}
}//







