package com.main.gharrImaratApp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(UserAgentId.class)
public class UserAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID userAgent1ID;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID userAgent2ID; 
    
	private String userAgentName;
	private String userAgentEmail; 
	private String userAgentPassword; 
	private String userAgentContact; 
	private String userAgentAddress; 
	private String typeOfDeals;
	private String typeOfResidentialProperties;
	private String operatingSince;
	private String expertiseIn;
	private String descriptionOfBusiness;
	private String canProvidesLoan;
	private String localTime; //(use LocalTime Class)
	private String localDate; //(user LocalDate Class)
	private String userType;
	
	@OneToMany(cascade = CascadeType.ALL) 
    private List<PropertyRentAndBuy> propertyRentAndBuyList=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<PropertyPG> propertyPGList=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<EnquiryBox> enquiryBoxs=new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL)
    private ProfilePictureAgent pictureAgent;
}//

