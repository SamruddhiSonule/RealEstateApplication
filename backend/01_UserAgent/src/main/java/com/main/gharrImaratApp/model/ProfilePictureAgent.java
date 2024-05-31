package com.main.gharrImaratApp.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProfilePictureAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID profilePicIDUuid;
	private byte[] profilePic;
}//
