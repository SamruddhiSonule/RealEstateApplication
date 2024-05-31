package com.main.gharrImaratApp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.PropertyPG;
import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.model.UserAgent;

public interface PropertyPGServiceInterface {

//	UserAgent updatePropertyPG(UUID userAgent1ID, UUID userAgent2ID, String text, MultipartFile[] images);

	public UserAgent updatePropertyPG(UUID userAgent1ID, UUID userAgent2ID, PropertyPG propertyPG);

	public PropertyPG updateSharingRoomsPG(UUID propertyPGID, String text, MultipartFile[] images);

	public Optional<PropertyPG> getPropertyPG(UUID propertyPGID);

	public List<PropertyPG> getPropertyPGByNoOfBedsAvailable(String totalNoOfBeds);

	public List<PropertyPG> getPropertyPGByAvailableFor(String availableFor);

	public List<PropertyPG> getAllPropPG(UUID userAgent1ID, UUID userAgent2ID);

	public List<PropertyPG> getFilteredProperties(String locality, int onePersonRent, String availableFor,
			String foodAvailability, String acRoomsAvailability, String powerBackup);

	public List<PropertyPG> getPropertyPGByLAR(String locality, String availableFor, int onePersonRent);

	public List<SharingRooms> getFilteredRoomsBySA(UUID propertyPGID, String sharing, String availableFor);

}
