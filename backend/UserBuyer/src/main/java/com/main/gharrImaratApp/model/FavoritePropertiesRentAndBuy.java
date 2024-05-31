package com.main.gharrImaratApp.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoritePropertiesRentAndBuy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID propertyRBID; 
	 @Column(unique = true)
	private UUID propertyRBIDSave;
	private UUID userBuyer1ID;
	private UUID userBuyer2ID;
    private String localTime;
    private String localDate;
//	
//	@NotBlank(message = "Property name cannot be blank")
//    private String propertyRBName;
//
//    @NotBlank(message = "Description cannot be blank")
//    private String description;
//
//    @NotBlank(message = "Locality cannot be blank")
//    private String propertyLocality;
//
//    @Min(value = 0, message = "Price must be a positive number")
//    private int price;
//
//    @NotBlank(message = "Location cannot be blank")
//    private String location;
//
//    @NotBlank(message = "Flat BHK cannot be blank")
//    private String flatBHK;
//
//    @NotBlank(message = "Balcony cannot be blank")
//    private String balcony;
//
//    @NotBlank(message = "Parking cannot be blank")
//    private String parking;
//
//    @NotBlank(message = "Property type cannot be blank")
//    private String propertyTYPE;
//
//    @NotBlank(message = "Carpet area cannot be blank")
//    private String carpetArea;
//
//    @NotBlank(message = "Facing direction cannot be blank")
//    private String facing;
//
//    @NotBlank(message = "Construction phase cannot be blank")
//    private String constructionPhase;
//
//    @NotBlank(message = "Furnishing status cannot be blank")
//    private String furnishing;
//
//    @NotBlank(message = "Society name cannot be blank")
//    private String societyName;
//
//    @NotBlank(message = "Check Loan Eligibility cannot be blank")
//    private String checkLonEligibilty;
//
//    @Min(value = 1, message = "Number of bathrooms must be at least 1")
//    private int numberOfBathroom;
//
//    @NotBlank(message = "Amenities name cannot be blank")
//    private String amenities;
//

//	@OneToMany(cascade = CascadeType.ALL)
//	List<PropertyImages> propertyImages;
//	@OneToMany(cascade = CascadeType.ALL)
//	List<PropertyReview> propertyReviews;
	

}
