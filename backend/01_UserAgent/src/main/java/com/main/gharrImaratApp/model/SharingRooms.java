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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SharingRooms {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID roomPGID;
	private String roomNo; 	
	private String sharing;
	private int rent; //
	private String foodAvailability;  
	private String amenities;
	private String location;
	private String availableFor;
	private UUID propertyPGID;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PropertyReview> propertyReviewes=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PropertyImages> propertyImages=new ArrayList<>();
}
