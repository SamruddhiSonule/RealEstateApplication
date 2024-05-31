package com.main.gharrImaratApp.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;


@Data
//@Entity
public class PropertyImages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID imageId;
	@Lob
	@Column(length=999999999)
	private byte[] imageFile;

}
