package com.main.gharrImaratApp.servicei;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.FavoritePropertiesPG;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.model.UserBuyer;

public interface FavoritePropertiesPGServicei {

	UserBuyer addPropertyPGToUserBuyer(UUID userBuyer1ID, UUID userBuyer2ID, FavoritePropertiesPG favoritePropertiesPG);

	List<FavoritePropertiesPG> getFavoritePropertiesPG(UUID userBuyer1ID, UUID userBuyer2ID);

	List<FavoritePropertiesPG> getPropertyPGByNoOfBedsAvailabl(String totalNoOfBeds);

	List<FavoritePropertiesPG> getPropertyPGByAvailableFor(String availableFor);

//	List<FavoritePropertiesPG> getFilteredPGProperties(String locality, int onePersonRent, String availableFor,
//			String foodAvailability, String acRoomsAvailability, String powerBackup);


//	FavoritePropertiesPG updateSharingRoomsPG(UUID propertyPGID, String text, MultipartFile[] images);

}
