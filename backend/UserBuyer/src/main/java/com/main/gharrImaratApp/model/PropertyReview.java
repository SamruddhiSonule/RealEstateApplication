package com.main.gharrImaratApp.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID reviewID;
	@GeneratedValue(strategy = GenerationType.UUID)
	@Id
 	private UUID userId;
	@Min(value = 0, message = "Rating must be between 1 to 5")
	@Max(value = 5, message = "Rating must be between 1 to 5")
	private int rating; 
	@NotBlank(message = "Comments cannot be null")
	private String comments; 
	private String localTime;
	private String localDate;

}
