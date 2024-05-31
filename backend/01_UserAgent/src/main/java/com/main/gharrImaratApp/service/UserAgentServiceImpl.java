package com.main.gharrImaratApp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.UserAgent;
import com.main.gharrImaratApp.repository.PropertyRentAndBuyRepository;
import com.main.gharrImaratApp.repository.UserAgentRepository;

@Service
public class UserAgentServiceImpl implements UserAgentServiceInterface{

	@Autowired UserAgentRepository userAgentRepository;
	
	@Autowired PropertyRentAndBuyRepository propertyRentAndBuyRepository;
	
	@Override
	public UserAgent addUserAgentRecord(UserAgent userAgent) {
		
		LocalTime localtime=LocalTime.now();
		LocalDate localDate=LocalDate.now();
		String localTme=localtime.toString();
		String localDte=localDate.toString();
		userAgent.setLocalTime(localTme);
		userAgent.setLocalDate(localDte);
		
		userAgent.getPropertyRentAndBuyList().add(null);
		userAgent.getPropertyPGList().add(null);

		return userAgentRepository.save(userAgent);
	}

	@Override
	public Optional<UserAgent> getSingleUserAgentRecord(UUID userAgent1ID, UUID userAgent2ID) {
		Optional<UserAgent>  userAgent=userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
		return userAgent;
	}

	@Override
	public Iterable<UserAgent> viewAllUserAgentRecords() {
		Iterable<UserAgent> list=userAgentRepository.findAll();
		return list;
	}

	@Override
	public UserAgent upadteUserAgentRecord(UUID userAgent1ID, UUID userAgent2ID, PropertyRentAndBuy properties) {
	    Optional<UserAgent> existingUserAgent = userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
	    

	    
	    if (existingUserAgent.isPresent()) {
	        UserAgent updateAgent = existingUserAgent.get();
	        
	        // Add the new property to the list
	        updateAgent.getPropertyRentAndBuyList().add(properties);
	        
	        // Save the updated user agent
	        return userAgentRepository.save(updateAgent);
	    } else {
	        // Handle the case where the data is not found
	        throw new NoSuchElementException("Data not found for provided UUIDs");
	    }
	}


	@Override
	public UserAgent deleteAgentRecord(UUID userAgent1ID, UUID userAgent2ID) {
		 Optional<UserAgent> existingUserAgent = userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
		 
		 if(existingUserAgent.isPresent())
		 {
			 UserAgent useragent=existingUserAgent.get();
			 userAgentRepository.delete(useragent);
			 return useragent;
		 }else {
			 
		      throw new NoSuchElementException("Data not found for provided UUIDs"); 
		 }
	}

	@Override
	public UserAgent getSingleUserAgentRecordByName(String userAgentPassword, String userAgentEmail) {
	    Optional<UserAgent> optionalUserAgent = userAgentRepository.findByUserAgentPasswordAndUserAgentEmail(userAgentPassword, userAgentEmail);
	    
	    return optionalUserAgent.orElse(null); // Return UserAgent if present, otherwise return null
	}

	@Override
	public List<PropertyRentAndBuy> getPropertyByRentAndBuy(UUID userAgent1ID, UUID userAgent2ID) {
		Optional<UserAgent> esxisting = userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
		      
		      if(esxisting.isPresent())
		      {
		    	  List<PropertyRentAndBuy> propertyRentAndBuy=new ArrayList<PropertyRentAndBuy>(); 
		    	  return propertyRentAndBuy;
		      }
		   return null;
	}

	@Override
	public UserAgent updateUserAgentRecord(UUID userAgent1ID, UUID userAgent2ID, UserAgent userAgent) {
		Optional<UserAgent> userAgent2=userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
		if(userAgent2.isPresent())
	      {
			LocalTime localtime=LocalTime.now();
			LocalDate localDate=LocalDate.now();
			String localTme=localtime.toString();
			String localDte=localDate.toString();
			userAgent.setLocalTime(localTme);
			userAgent.setLocalDate(localDte);
	    	return  userAgentRepository.save(userAgent);
	      }
		return null;
	}


	
}
