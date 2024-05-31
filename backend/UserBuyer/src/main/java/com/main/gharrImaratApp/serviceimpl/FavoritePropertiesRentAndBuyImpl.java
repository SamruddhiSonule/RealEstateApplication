package com.main.gharrImaratApp.serviceimpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.PropertyImages;
import com.main.gharrImaratApp.model.UserBuyer;
import com.main.gharrImaratApp.repository.FavoritePropertiesRentAndBuyRepository;
import com.main.gharrImaratApp.repository.UserBuyerRepository;
import com.main.gharrImaratApp.servicei.FavoritePropertiesRentAndBuyService;

@Service
public class FavoritePropertiesRentAndBuyImpl implements FavoritePropertiesRentAndBuyService {

    @Autowired
    FavoritePropertiesRentAndBuyRepository favoritePropertiesRentAndBuyRepository;
    @Autowired
    UserBuyerRepository userBuyerRepository;

//    @Override
//    public UserBuyer addPropertyRentANdBuyToUserBuyer(UUID userBuyer1ID, UUID userBuyer2ID, String text,
//            MultipartFile[] image) {
//
//        Optional<UserBuyer> userBuyer = userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(userBuyer1ID,
//                userBuyer2ID);
//        if (userBuyer.isPresent()) 
//        {
//            UserBuyer userBuyerDetails = userBuyer.get(); // Moved inside the if block
//            ObjectMapper mapper = new ObjectMapper();
//            try {
//                FavoritePropertiesRentAndBuy favoritePropertiesRentAndBuy = mapper.readValue(text,
//                        FavoritePropertiesRentAndBuy.class);
//
//                if (image != null) {
//                    List<PropertyImages> propertyImageslist = new ArrayList<>();
//                    for (MultipartFile img : image) { // processing each image
//                        PropertyImages propertyImage = new PropertyImages();
//                        propertyImage.setImageFile(img.getBytes());
//                        propertyImageslist.add(propertyImage);
//                    }
////                    favoritePropertiesRentAndBuy.setPropertyImages(propertyImageslist);
////                    favoritePropertiesRentAndBuy.setUserBuyer1ID(userBuyer1ID);
////                    favoritePropertiesRentAndBuy.setUserBuyer2ID(userBuyer2ID);
//                    LocalTime localtime = LocalTime.now();
//                    LocalDate localdate = LocalDate.now();
//                    favoritePropertiesRentAndBuy.setLocalTime(localtime.toString());
//                    favoritePropertiesRentAndBuy.setLocalDate(localdate.toString());
//                    
//
//                    userBuyerDetails.getFavoritePropertiesRentAndBuyList().add(favoritePropertiesRentAndBuy);
//
//                    return userBuyerRepository.save(userBuyerDetails);
//                }
//            } catch (JsonMappingException e) {
//                // Handle JSON mapping exception
//                e.printStackTrace();
//            } catch (JsonProcessingException e) {
//                // Handle JSON processing exception
//                e.printStackTrace();
//            } catch (IOException e) {
//                // Handle IO exception
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

    @Override
    public List<FavoritePropertiesRentAndBuy> getPropertyByRentAndBuy(UUID userBuyer1ID, UUID userBuyer2ID) {
        Optional<UserBuyer> optionalUserBuyer = userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(userBuyer1ID, userBuyer2ID);
       // Optional<UserBuyer> optionalUserBuyer = userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(userBuyer1ID, userBuyer2ID);

        if (optionalUserBuyer.isPresent()) {
            UserBuyer userBuyerDetails = optionalUserBuyer.get();
            System.out.println(userBuyerDetails);
            List<FavoritePropertiesRentAndBuy> favoritePropertiesRentAndBuyDetails = userBuyerDetails.getFavoritePropertiesRentAndBuyList();
                   
            // Check if favoritePropertiesRentAndBuyDetails is null or empty
            if (favoritePropertiesRentAndBuyDetails != null && !favoritePropertiesRentAndBuyDetails.isEmpty()) {
                return favoritePropertiesRentAndBuyDetails;
            } else {
                // Return an empty list instead of null to indicate no data found
                return Collections.emptyList();
            }
        } else {
            // Return an empty list instead of null to indicate no data found
            return Collections.emptyList();
        }
    }

	@Override
	public UserBuyer addPropertyRentANdBuyToUserBuyer(UUID userBuyer1ID, UUID userBuyer2ID,
			FavoritePropertiesRentAndBuy favoritePropertiesRentAndBuy) {
		Optional<UserBuyer> userOptional= userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(userBuyer1ID, userBuyer2ID);
		if(userOptional.isPresent())
		{
		UserBuyer userBuyer=	userOptional.get();
		userBuyer.getFavoritePropertiesRentAndBuyList().add(favoritePropertiesRentAndBuy);
		return userBuyerRepository.save(userBuyer);
		}
		return null;
	}

	@Override
	public FavoritePropertiesRentAndBuy deleteProperty(UUID uerrBuyer1ID, UUID userBuyer2ID,UUID propertyRBID2) {
		 Optional<UserBuyer> uOptional = userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(uerrBuyer1ID, userBuyer2ID);
		System.out.println(uOptional.isPresent());
		 if(uOptional.isPresent())
		 {
			UserBuyer userBuyer= uOptional.get();
		
			List<FavoritePropertiesRentAndBuy> list=userBuyer.getFavoritePropertiesRentAndBuyList();
			Iterator<FavoritePropertiesRentAndBuy> iterator = list.iterator();
			 while (iterator.hasNext()) {
		            FavoritePropertiesRentAndBuy favoritePropertiesRentAndBuy = iterator.next();
		            if (favoritePropertiesRentAndBuy.getPropertyRBID().equals(propertyRBID2)) {
		                iterator.remove();
		                favoritePropertiesRentAndBuyRepository.delete(favoritePropertiesRentAndBuy);
		                System.out.println("Deleted...!");
		            }
		        }
//			for (FavoritePropertiesRentAndBuy favoritePropertiesRentAndBuy : list) {
//				if(favoritePropertiesRentAndBuy.getPropertyRBID().equals(propertyRBID2)) {
//					list.remove(favoritePropertiesRentAndBuy);
//					favoritePropertiesRentAndBuyRepository.delete(favoritePropertiesRentAndBuy);
//					System.out.println("deleted...!");
//				}
//			}
		 }
		return null;
	}

	@Override
	public FavoritePropertiesRentAndBuy getPropertyByRentAndBuyByPropID(UUID userBuyer1ID, UUID userBuyer2ID,
			UUID propertyRBIDSave) {
	Optional<UserBuyer> usOptional = userBuyerRepository.findByUserBuyer1IDAndUserBuyer2ID(userBuyer1ID, userBuyer2ID);
	if(usOptional.isPresent() && ! propertyRBIDSave.equals("null"))
	{
	UserBuyer userBuyer = usOptional.get();
	List<FavoritePropertiesRentAndBuy> list= userBuyer.getFavoritePropertiesRentAndBuyList();
	for (FavoritePropertiesRentAndBuy favoritePropertiesRentAndBuy : list) {
		if(favoritePropertiesRentAndBuy.getPropertyRBIDSave().equals(propertyRBIDSave)) {
			return favoritePropertiesRentAndBuy;
		}
	}
	}
	return null;
	}

//	@Override
//	public List<FavoritePropertiesRentAndBuy> getFilteredProperties(String propertyLocality, int price,
//			String propertyType, String furnishing, String facing, String constructionPhase, String flatBHK) {
//		
//		List<FavoritePropertiesRentAndBuy> list=favoritePropertiesRentAndBuyRepository.findAll();
//	     Stream<FavoritePropertiesRentAndBuy> stream = list.stream();
//	     
//	     if(!propertyLocality.equals("null"))
//	     {
//	    	 stream = stream.filter(prop->(prop.getPropertyLocality().equals(propertyLocality)));
//	     }
//	     if(price > 0)
//	     {
//	    	 System.out.println("check price");
//	    	 stream=stream.filter(prop->prop.getPrice()<=price);
//	     }
//	     if(!propertyType.equals("null"))
//	     {
//	    	 System.out.println("Check Property Type");
//	    	 stream=stream.filter(prop->prop.getPropertyTYPE().equals(propertyType));
//	     }
//	     if(!furnishing.equals("null"))
//	     {
//	    	 System.out.println("Check furnishing");
//	    	 stream=stream.filter(prop->prop.getFurnishing().equals(furnishing));
//	     }
//	     if(!facing.equals("null"))
//	     {
//	    	 System.out.println("check facing");
//	    	 stream=stream.filter(prop->prop.getFacing().equals(facing));
//	     }
//	     if(!constructionPhase.equals(constructionPhase))
//	     {
//	    	 System.out.println("Check Construction Phase");
//	    	 stream=stream.filter(prop->prop.getConstructionPhase().equals(constructionPhase));
//	     }
//	     if(!flatBHK.equals("null"))
//	     {
//	    	 System.out.println("Check Flat BHK");
//	    	 stream=stream.filter(prop->prop.getFlatBHK().equals(flatBHK));
//	     }
//	     List<FavoritePropertiesRentAndBuy>list1=stream.collect(Collectors.toList());
//	    	 
//		return list1;
//	}




	
	
	
	
}
