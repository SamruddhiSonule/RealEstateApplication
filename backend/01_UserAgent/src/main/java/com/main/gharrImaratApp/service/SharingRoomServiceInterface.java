package com.main.gharrImaratApp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.PropertyPG;
import com.main.gharrImaratApp.model.SharingRooms;

public interface SharingRoomServiceInterface {

	public PropertyPG updateSharingRoomsPG(UUID propertyPGID, String text, MultipartFile[] images);

	public SharingRooms updateSharingRoomsReviewsPG(UUID roomPGID, String text, MultipartFile[] images);

	public List<SharingRooms> getPropertySharingRoomsBySharing(String sharing);

	public List<SharingRooms> getPropertySharingRoomsByRent(int rent);

	public List<SharingRooms> getPropertySharingRoomsByFooDAailablity(String foodAvailability);

	public List<SharingRooms> getSharingRoomsByLocationPriceBudget(String location, String availableFor, int rent);

	public List<SharingRooms> getAllPropertySharingRoomsByPI(UUID propertyPGID);

	

}
