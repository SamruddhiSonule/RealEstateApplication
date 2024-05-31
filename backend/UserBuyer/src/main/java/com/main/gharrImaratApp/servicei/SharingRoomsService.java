package com.main.gharrImaratApp.servicei;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.FavoritePropertiesPG;
import com.main.gharrImaratApp.model.PropertyReview;
import com.main.gharrImaratApp.model.SharingRooms;

public interface SharingRoomsService {

	FavoritePropertiesPG updateSharingRoomsPG(UUID propertyPGID, String text, MultipartFile[] images);

	SharingRooms updateSharingRoomsReviewsPG(UUID roomPGID, PropertyReview propertyReview);

	List<SharingRooms> getSharingRoomsByLocationPriceBudget(String location, String availableFor, String rent);

	List<SharingRooms> getPropertySharingRoomsBySharing(String sharing);

	List<SharingRooms> getPropertySharingRoomsByRent(int rent);

	List<SharingRooms> getPropertySharingRoomsByFooDAailablity(String foodAvailability);

	

	

}
