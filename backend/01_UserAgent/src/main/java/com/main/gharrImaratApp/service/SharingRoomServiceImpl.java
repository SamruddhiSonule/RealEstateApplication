package com.main.gharrImaratApp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.gharrImaratApp.model.PropertyImages;
import com.main.gharrImaratApp.model.PropertyPG;
import com.main.gharrImaratApp.model.PropertyReview;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.repository.PropertyPGRepository;
import com.main.gharrImaratApp.repository.SharingRoomRepository;

@Service
public class SharingRoomServiceImpl implements SharingRoomServiceInterface{

	@Autowired PropertyPGRepository propertyPGRepository;
	@Autowired SharingRoomRepository sharingRoomRepository;
	
	
	@Override
	public PropertyPG updateSharingRoomsPG(UUID propertyPGID, String text, MultipartFile[] images) {
		Optional<PropertyPG> propertyPg=propertyPGRepository.findByPropertyPGID(propertyPGID);
		
		if(propertyPg.isPresent()) {
			PropertyPG property=propertyPg.get();
			
			ObjectMapper mapper=new ObjectMapper();
			
			try {
				SharingRooms sharingRooms=mapper.readValue(text, SharingRooms.class);
				
				if(images!=null)
				{
					List<PropertyImages> propertyImageList=new ArrayList<>();
					
					for(MultipartFile img: images) {
						PropertyImages propertyImage=new PropertyImages();
						propertyImage.setImage(img.getBytes());
						propertyImageList.add(propertyImage);
					}
					sharingRooms.getPropertyImages().addAll(propertyImageList);
					
					property.getSharingRooms().add(sharingRooms);
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
	public SharingRooms updateSharingRoomsReviewsPG(UUID roomPGID, String text, MultipartFile[] images) {
		Optional<SharingRooms>  updatedReviews=sharingRoomRepository.findById(roomPGID);
		 
	    if(updatedReviews.isPresent())
	    {
	    	SharingRooms sharingRooms=updatedReviews.get();
	    	
	    }
		return null;
			
			
	}


	@Override
	public List<SharingRooms> getPropertySharingRoomsBySharing(String sharing) {
		List<SharingRooms> setSharingRooms=sharingRoomRepository.findBySharing(sharing);
		return setSharingRooms;
	}


	@Override
	public List<SharingRooms> getPropertySharingRoomsByRent(int rent) {
		List<SharingRooms> getPGByRent=sharingRoomRepository.findByRentLessThan(rent);
		return getPGByRent;
	}


	@Override
	public List<SharingRooms> getPropertySharingRoomsByFooDAailablity(String foodAvailability) {
		List<SharingRooms> getPGFoodAvailability=sharingRoomRepository.findByFoodAvailability(foodAvailability);
		return getPGFoodAvailability;
	}


	@Override
	public List<SharingRooms> getSharingRoomsByLocationPriceBudget(String location, String availableFor, int rent) {
		List<SharingRooms> getLocationAndAvailableForAndRent=sharingRoomRepository.findByLocationAndAvailableForAndRent(location, availableFor, rent);
		return getLocationAndAvailableForAndRent;
	}


	@Override
	public List<SharingRooms> getAllPropertySharingRoomsByPI(UUID propertyPGID) {
		Optional<PropertyPG> prOptional=propertyPGRepository.findById(propertyPGID);
		if(prOptional.isPresent())
		{
				 PropertyPG pg	=prOptional.get();
				 List<SharingRooms> list = pg.getSharingRooms();
				 return list;
		}
		return null;
	}

}
