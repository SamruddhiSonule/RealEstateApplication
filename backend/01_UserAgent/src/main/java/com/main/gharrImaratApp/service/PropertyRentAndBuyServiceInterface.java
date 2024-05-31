package com.main.gharrImaratApp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.UserAgent;

public interface PropertyRentAndBuyServiceInterface {

	public UserAgent addpropertyRentAndBuyRecord(UUID userAgent1ID, UUID userAgent2ID, String text, MultipartFile[] image);

	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByLocationFlatBHKPrice(String location, String flatBHK,
			int price, String forSaleOrRentString);

	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByPrice(int price);

	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByPropertyType(String propertyTYPE);

	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByFurnishing(String furnishing);

	public List<PropertyRentAndBuy> getPropertyByRentAndBuyByNoOfBathrooms(int numberOfBathroom);

	public List<PropertyRentAndBuy> getPropertyByRentAndBuy(UUID userAgent1ID, UUID userAgent2ID);

	public List<PropertyRentAndBuy> getPropertyByRentAndBuyBypropertyLocality(String propertyLocality);

	public List<PropertyRentAndBuy> getFilteredProperties(String propertyLocality, int price, String propertyType,
			String furnishing, String forSaleOrRentString, String facing, String constructionPhase, String flatBHK);

	public List<PropertyRentAndBuy> getAllProperTyRentAndBuy();


}
