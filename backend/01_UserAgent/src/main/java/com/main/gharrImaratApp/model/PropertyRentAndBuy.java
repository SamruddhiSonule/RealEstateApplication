package com.main.gharrImaratApp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PropertyRentAndBuy {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID propertyRentAndBuyId;
	
	private String propertyRBName; 	
	private String description;
	private String propertyLocality;
	private int price; 
	private String location; 
	private String flatBHK; 
	private String balcony;
	private String parking;
	private String propertyTYPE; 
	private int carpetArea; 
	private String facing;
	private String constructionPhase; 
	private String furnishing; 
	private String societyName; 
	private String checkLonEligibilty; 
	private String imagesOFProperties;
	private int numberOfBathroom;
	private String amenities;
	private String localTime;
	private String localDate;
	private String forSaleOrRentString;
	private UUID userAgent1ID;
	private UUID userAgent2ID;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PropertyReview> propertyReviews=new ArrayList();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PropertyImages> propertyImages=new ArrayList<>();
	

}
