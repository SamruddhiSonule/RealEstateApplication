package com.main.gharrImaratApp.servicei;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.UserBuyer;

public interface FavoritePropertiesRentAndBuyService {
//
//	UserBuyer addPropertyRentANdBuyToUserBuyer(UUID userBuyer1ID, UUID userBuyer2ID, String text,
//			MultipartFile[] image);

	List<FavoritePropertiesRentAndBuy> getPropertyByRentAndBuy(UUID userBuyer1ID, UUID userBuyer2ID);

	UserBuyer addPropertyRentANdBuyToUserBuyer(UUID userBuyer1ID, UUID userBuyer2ID,
			FavoritePropertiesRentAndBuy favoritePropertiesRentAndBuy);

	FavoritePropertiesRentAndBuy deleteProperty(UUID propertyRBID, UUID userBuyer2ID, UUID propertyRBID2);

	FavoritePropertiesRentAndBuy getPropertyByRentAndBuyByPropID(UUID userBuyer1ID, UUID userBuyer2ID,
			UUID propertyRBIDSave);

//	List<FavoritePropertiesRentAndBuy> getFilteredProperties(String propertyLocality, int price, String propertyType,
//			String furnishing, String facing, String constructionPhase, String flatBHK);



}
