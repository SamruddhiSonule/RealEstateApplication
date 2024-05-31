package com.main.gharrImaratApp.model;


import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserBuyerId.class)
public class UserBuyer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID userBuyer1ID;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID userBuyer2ID;
	@NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
	private String userBuyerName;
	@Email(message = "Invalid email format")
	private String userBuyerEmail;
	@NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 10, message = "Password must be between 6 and 255 characters")
	private String userBuyerPassword;
	@Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
	private String userBuyerContact;
	private String userBuyerAddress;
	private String localTime;
	private String localDate;
	private String userType;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<FavoritePropertiesRentAndBuy> favoritePropertiesRentAndBuyList;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<FavoritePropertiesPG> favoritePropertiesPGList;
	
	

}
