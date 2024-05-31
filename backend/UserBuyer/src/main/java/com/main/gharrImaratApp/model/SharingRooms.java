package com.main.gharrImaratApp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharingRooms {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID roomPGID;
	//private UUID userBuyer1ID;
	//private UUID userBuyer2ID;
	private UUID propertyPGID;
	@NotBlank(message="RoomNo cannot be blank")
	private String roomNo; 
//	@NotBlank(message="sharing cananot be blank")
//	private String sharing;
//	@Min(value = 0, message = "Rent must be a positive number")
//	private int rent;
//	@NotBlank(message="availableFor cannot be blank")
//	private String availableFor;
//	@NotBlank(message="foodAvailability cannot be blank")
//	private String foodAvailability; 
//	@NotBlank(message="Amenities cannot be blank")
//	private String amenities;
//	@NotBlank(message="Location cannot be blank")
//	private String location;
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	List<PropertyImages> propertyImages = new ArrayList<>();
//	@OneToMany(cascade = CascadeType.ALL)
//	List<PropertyReview> propertyReviews;

}
