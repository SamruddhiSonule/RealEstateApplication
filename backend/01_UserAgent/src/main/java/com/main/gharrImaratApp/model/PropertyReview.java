package com.main.gharrImaratApp.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(PropertyReviewId.class)
public class PropertyReview {


	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID reviewID;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
 	private UUID userId;
	private int rating; 
	private String comments; 
	private String localTime;  //(use LocalTime)
	private String localDate;  //(use LocalDate).
}
