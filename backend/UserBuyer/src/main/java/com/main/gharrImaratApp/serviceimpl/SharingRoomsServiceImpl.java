package com.main.gharrImaratApp.serviceimpl;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.gharrImaratApp.model.FavoritePropertiesPG;
import com.main.gharrImaratApp.model.PropertyImages;
import com.main.gharrImaratApp.model.PropertyReview;
import com.main.gharrImaratApp.model.SharingRooms;
import com.main.gharrImaratApp.repository.FavoritePropertiesPGRepository;
import com.main.gharrImaratApp.repository.SharingRoomsRepository;
import com.main.gharrImaratApp.servicei.SharingRoomsService;

@Service
public class SharingRoomsServiceImpl implements SharingRoomsService {
	@Autowired
	SharingRoomsRepository sharingRoomsRepository;
	@Autowired
	FavoritePropertiesPGRepository favoritePropertiesPGRepository;

	@Override
	public FavoritePropertiesPG updateSharingRoomsPG(UUID propertyPGID, String text, MultipartFile[] images) {
		Optional<FavoritePropertiesPG> optionalFavoritePropertiesPG = favoritePropertiesPGRepository
				.findByPropertyPGID(propertyPGID);
		

		if (optionalFavoritePropertiesPG.isPresent()) {
			FavoritePropertiesPG favoritePropertiesPGDetails = optionalFavoritePropertiesPG.get();

			ObjectMapper mapper = new ObjectMapper();

			try {
				SharingRooms sharingRooms = mapper.readValue(text, SharingRooms.class);
				if (images != null) {
					List<PropertyImages> propertyImagesList = new ArrayList<>();
					for (MultipartFile image : images) {
						PropertyImages propertyImages = new PropertyImages();
						propertyImages.setImageFile(image.getBytes());
						propertyImagesList.add(propertyImages);
					}
//					sharingRooms.getPropertyImages().addAll(propertyImagesList);
					sharingRooms.setPropertyPGID(propertyPGID);
//					favoritePropertiesPGDetails.getSharingRooms().add(sharingRooms);
					return favoritePropertiesPGRepository.save(favoritePropertiesPGDetails);

				}
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public SharingRooms updateSharingRoomsReviewsPG(UUID roomPGID, PropertyReview propertyReview) {

		SharingRooms sharingRooms = sharingRoomsRepository.findByRoomPGID(roomPGID);
//		List<PropertyReview> sharingRoomsList = sharingRooms.getPropertyReviews();
//		sharingRoomsList.add(propertyReview);
		 LocalTime localtime = LocalTime.now();
		 LocalDate localdate = LocalDate.now();
		 propertyReview.setLocalTime(localtime.toString());
		 propertyReview.setLocalDate(localdate.toString());
//		sharingRooms.setPropertyReviews(sharingRoomsList);
		return sharingRoomsRepository.save(sharingRooms);
	}

	@Override
	public List<SharingRooms> getSharingRoomsByLocationPriceBudget(String location, String availableFor, String rent) {
		List<SharingRooms> list= sharingRoomsRepository.findBySharingRoomsByLocationPriceBudget(location, availableFor, rent);
		return list;
	}

	@Override
	public List<SharingRooms> getPropertySharingRoomsBySharing(String sharing) {
		List<SharingRooms> list = sharingRoomsRepository.findByPropertySharingRoomsBySharing(sharing);
		return list;
	}

	@Override
	public List<SharingRooms> getPropertySharingRoomsByRent(int rent) {
		List<SharingRooms> list= sharingRoomsRepository.findByPropertySharingRoomsByRent(rent);
		return list;
	}

	@Override
	public List<SharingRooms> getPropertySharingRoomsByFooDAailablity(String foodAvailability) {
		List<SharingRooms> list=sharingRoomsRepository.findByPropertySharingRoomsByFooDAailablity(foodAvailability);
		return list;
	}

}