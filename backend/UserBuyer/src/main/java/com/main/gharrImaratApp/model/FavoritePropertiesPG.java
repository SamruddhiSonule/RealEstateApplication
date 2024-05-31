package com.main.gharrImaratApp.model;

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
public class FavoritePropertiesPG {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID propertyPGID; 
	private UUID propertyPGIDSave; 
	private UUID userBuyer1ID;
	private UUID userBuyer2ID;
	private String localTime;
	private String localDate;
//	@NotBlank(message = "Property name cannot be blank")
//	private String propertyPGName;
//
//	@NotBlank(message = "Description cannot be blank")
//	private String description;
//
//	@NotBlank(message = "Deposit amount cannot be blank")
//	private String depositeAmmount;
//
//	@NotBlank(message = "Notice period cannot be blank")
//	private String noticePeriod;
//
//	@NotBlank(message = "Food availability cannot be blank")
//	private String foodAvailability;
//
//	@NotBlank(message = "AC rooms availability cannot be blank")
//	private String acRoomsAvailability;
//
//	@NotBlank(message = "Parking availability cannot be blank")
//	private String parking;
//
//	@NotBlank(message = "Power backup availability cannot be blank")
//	private String powerBackup;
//
//	@NotBlank(message = "Available for cannot be blank")
//	private String availableFor;
//
//	@NotBlank(message = "Total number of beds cannot be blank")
//	private String totalNoOfBeds;
//
//	@NotBlank(message = "Locality cannot be blank")
//	private String locality;
//
//	@Min(value = 0, message="onePersonRent should be a positive number")
//	private int onePersonRent;

//	
//	@OneToMany(cascade = CascadeType.ALL)
//	List<SharingRooms> sharingRooms;
//	

}
