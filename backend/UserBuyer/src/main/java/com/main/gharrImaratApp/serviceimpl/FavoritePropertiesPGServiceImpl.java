package com.main.gharrImaratApp.serviceimpl;


import java.io.IOException;
import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.gharrImaratApp.model.FavoritePropertiesPG;
import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.PropertyImages;
import com.main.gharrImaratApp.model.UserBuyer;
import com.main.gharrImaratApp.repository.FavoritePropertiesPGRepository;
import com.main.gharrImaratApp.repository.UserBuyerRepository;
import com.main.gharrImaratApp.servicei.FavoritePropertiesPGServicei;

@Service
public class FavoritePropertiesPGServiceImpl implements FavoritePropertiesPGServicei{

	
	@Autowired FavoritePropertiesPGRepository favoritePropertiesPGRepository;
	
	@Autowired UserBuyerRepository userBuyerRepository;

	@Override
	public UserBuyer addPropertyPGToUserBuyer(UUID userBuyer1ID, UUID userBuyer2ID, FavoritePropertiesPG favoritePropertiesPG) {
		
		Optional<UserBuyer> optionalUserBuyer=userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(userBuyer1ID, userBuyer2ID);
		if(optionalUserBuyer.isPresent())
		{
			UserBuyer addPGDetails = optionalUserBuyer.get();
			
			LocalTime localtime = LocalTime.now();
	        LocalDate localdate = LocalDate.now();
	        favoritePropertiesPG.setLocalTime(localtime.toString());
	        favoritePropertiesPG.setLocalDate(localdate.toString());
	        favoritePropertiesPG.setUserBuyer1ID(userBuyer1ID);
	        favoritePropertiesPG.setUserBuyer2ID(userBuyer2ID);
		
	        addPGDetails.getFavoritePropertiesPGList().add(favoritePropertiesPG);
	        UserBuyer userBuyer= userBuyerRepository.save(addPGDetails);
	
		return userBuyer;
	}
		return null;
	}

	@Override
	public List<FavoritePropertiesPG> getFavoritePropertiesPG(UUID userBuyer1ID, UUID userBuyer2ID) {
		Optional<UserBuyer> optionalUserBuyer=userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(userBuyer1ID, userBuyer2ID);
		
		if(optionalUserBuyer.isPresent()) {
			UserBuyer userBuyerDetails = optionalUserBuyer.get();
			System.out.println(userBuyerDetails);
			List<FavoritePropertiesPG> favoritePropertiesPGsDetails=userBuyerDetails.getFavoritePropertiesPGList();
			
			if(favoritePropertiesPGsDetails != null && !favoritePropertiesPGsDetails.isEmpty()) {
				return favoritePropertiesPGsDetails;
			}else {
                // Return an empty list instead of null to indicate no data found
                return Collections.emptyList();
            }
        } else {
            // Return an empty list instead of null to indicate no data found
            return Collections.emptyList();
        }
		
	
	}

	@Override
	public List<FavoritePropertiesPG> getPropertyPGByNoOfBedsAvailabl(String totalNoOfBeds) {
		List<FavoritePropertiesPG> list=favoritePropertiesPGRepository.findByTotalNoOfBeds(totalNoOfBeds);
		return list;
	}

	@Override
	public List<FavoritePropertiesPG> getPropertyPGByAvailableFor(String availableFor) {
		List<FavoritePropertiesPG> list=favoritePropertiesPGRepository.findByAvailableFor(availableFor);
		return list;
	}

//	@Override
//	public List<FavoritePropertiesPG> getFilteredPGProperties(String locality, int onePersonRent,
//			String availableFor, String foodAvailability, String acRoomsAvailability, String powerBackup) {
//		
//		List<FavoritePropertiesPG> list=favoritePropertiesPGRepository.findAll();
//		Stream<FavoritePropertiesPG> stream=list.stream();
//		
//		if(!locality.equals("null"))
//		{
//			stream=stream.filter(prop->(prop.getLocality().equals(locality)));
//		}
//		if(onePersonRent > 0)
//		{
//			stream=stream.filter(prop->(prop.getOnePersonRent()<=onePersonRent));
//		}
//		if(!availableFor.equals("null"))
//		{
//			stream=stream.filter(prop->(prop.getAvailableFor().equals(availableFor)));
//		}
//		if(!foodAvailability.equals("null"))
//		{
//			stream=stream.filter(prop->(prop.getFoodAvailability().equals(foodAvailability)));
//		}
//		if(!acRoomsAvailability.equals("null"))
//		{
//			stream=stream.filter(prop->(prop.getAcRoomsAvailability().equals(acRoomsAvailability)));
//		}
//		if(!powerBackup.equals("null"))
//		{
//			stream=stream.filter(prop->(prop.getPowerBackup().equals(powerBackup)));
//		}
//		List<FavoritePropertiesPG> list1=stream.collect(Collectors.toList());
//		
//		return list1;
//	}
	

}
