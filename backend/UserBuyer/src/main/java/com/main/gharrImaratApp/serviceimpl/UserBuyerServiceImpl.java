package com.main.gharrImaratApp.serviceimpl;

import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.UserBuyer;
import com.main.gharrImaratApp.model.UserBuyerId;
import com.main.gharrImaratApp.repository.UserBuyerRepository;
import com.main.gharrImaratApp.servicei.UserBuyerService;

@Service
public class UserBuyerServiceImpl implements UserBuyerService{
	
	@Autowired UserBuyerRepository userBuyerRepository;

	@Override
	public UserBuyer addUserBuyerDetails(UserBuyer userBuyer) {
		
		LocalTime localtime=LocalTime.now();
		LocalDate localdate=LocalDate.now();
		String localTime=localtime.toString();
		String localDate=localdate.toString();
		userBuyer.setLocalTime(localTime);
		userBuyer.setLocalDate(localDate);
		
		for(int i=1;i<=10;i++)
		{
			System.out.println("Mi aai la prem karto.." + i);
			
		}
		System.out.println(userBuyer.getUserBuyerContact());
		System.out.println(userBuyer.getUserBuyerAddress());
		System.out.println(userBuyer.getUserBuyerContact());
		
		
		
		
		return userBuyerRepository.save(userBuyer);
	}

	@Override
	public Iterable<UserBuyer> getAllUserBuyerDetails() {
		// TODO Auto-generated method stub
		return userBuyerRepository.findAll();
	}

	@Override
	public UserBuyer updateUserBuyerDetails(UUID userBuyer1ID, UUID userBuyer2ID, UserBuyer updatedUserBuyer) {
	    // Find the UserBuyer entity using the composite IDs
	    Optional<UserBuyer> optionalUserBuyer = userBuyerRepository.findById(new UserBuyerId(userBuyer1ID, userBuyer2ID));
	    
	    if (optionalUserBuyer.isPresent()) {
	        UserBuyer updateUserBuyer = optionalUserBuyer.get();
	        updateUserBuyer.setUserBuyerName(updatedUserBuyer.getUserBuyerName());
	        updateUserBuyer.setUserBuyerEmail(updatedUserBuyer.getUserBuyerEmail());
	        updateUserBuyer.setUserBuyerPassword(updatedUserBuyer.getUserBuyerPassword());
	        updateUserBuyer.setUserBuyerContact(updatedUserBuyer.getUserBuyerContact());
	        updateUserBuyer.setUserBuyerAddress(updatedUserBuyer.getUserBuyerAddress());
	        LocalTime localtime = LocalTime.now();
	        LocalDate localdate = LocalDate.now();
	        updatedUserBuyer.setLocalTime(localtime.toString());
	        updatedUserBuyer.setLocalDate(localdate.toString());
	        updatedUserBuyer.setUserBuyer1ID(userBuyer1ID);
	        updatedUserBuyer.setUserBuyer2ID(userBuyer2ID);
	        

	        return userBuyerRepository.save(updateUserBuyer);
	    } else {
	        
	        return null;
	    }
	}

	@Override
	public void deleteUserBuyerRecord(UUID userBuyer1ID, UUID userBuyer2ID) {
		 // Find the UserBuyer entity using the composite IDs
        Optional<UserBuyer> optionalUserBuyer = userBuyerRepository.findById(new UserBuyerId(userBuyer1ID, userBuyer2ID));
        
       
        if (optionalUserBuyer.isPresent()) {
            
            userBuyerRepository.deleteById(new UserBuyerId(userBuyer1ID, userBuyer2ID));
        } 
		
	}


	@Override
	public UserBuyer getSingleUserBuyerRecordByuserBuyer1ID_and_userBuyer2ID(UUID userBuyer1ID, UUID userBuyer2ID) {
		
		Optional<UserBuyer> list=userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(userBuyer1ID, userBuyer2ID);
	UserBuyer userBuyer=	list.get();
		return userBuyer;
	}

	@Override
	public UserBuyer getSingleUserBuyerRecordByEmailAndPassword(String userBuyerEmail, String userBuyerPassword) {
		
		return userBuyerRepository.findByUserBuyerEmailAnduserBuyerPassword(userBuyerEmail, userBuyerPassword);
	}



	

	
	
	
	
	
	
	
	
	
	





	
	
	

	
}
