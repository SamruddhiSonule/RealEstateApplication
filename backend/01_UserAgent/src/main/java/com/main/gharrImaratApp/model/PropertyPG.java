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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PropertyPG {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID propertyPGID; 
    private	String propertyPGName; 	
    private	String description; 
    private int depositeAmmount; 
    private	String noticePeriod; 
    private String foodAvailability; 
    private String acRoomsAvailability; //add
    private	String parking; 
    private String locality;//add
    private String location;
    private int onePersonRent;//add
    private	String powerBackup; 
    private	String availableFor;
    private	String totalNoOfBeds;
    private	String localTime;
    private	String localDate;
    private UUID userAgent1ID;
    private UUID userAgent2ID;
	
    @OneToMany(cascade = CascadeType.ALL)
    private List<SharingRooms> sharingRooms=new ArrayList<>();
    
    
    
}
