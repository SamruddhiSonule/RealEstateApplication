package com.main.gharrImaratApp.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EnquiryBox {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID enquiryBoxID; 
	private UUID enquirySender1ID;
	private UUID enquirySender2ID; //add 
	private UUID enquiryGetter1ID;
	private UUID enquiryGetter2ID;//add
	private String enquiryMessage;
	private String personMail;
	private String mailSender;
	private String mailReciever;
	private String subject;
	private String nameOfPerson;
	private UUID propertyId;
	private String propertyLocatilty;
	private String location;
	private String locaTimeStamp;
	private String localDate;
	private String status;
}//
