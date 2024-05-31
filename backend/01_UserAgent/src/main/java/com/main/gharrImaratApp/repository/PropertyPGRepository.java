package com.main.gharrImaratApp.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.gharrImaratApp.model.PropertyPG;
import com.main.gharrImaratApp.model.PropertyRentAndBuy;

public interface PropertyPGRepository extends JpaRepository<PropertyPG, UUID>{

//	@Query(value = "SELECT * FROM propertypg WHERE propertyPGID = : propertyPGID", nativeQuery = true)
//	Optional<PropertyPG> findByPropertyPGID(@Param("propertyPGID") UUID propertyPGID);
	
	@Query(value = "SELECT * FROM propertypg WHERE propertyPGID = :propertyPGID", nativeQuery = true)
	Optional<PropertyPG> findByPropertyPGID(@Param("propertyPGID") UUID propertyPGID);

//	@Query(value="SELECT * FROM propertypg WHERE total_No_Of_Beds = :totalNoOfBeds", nativeQuery = true)
//	Optional<PropertyPG> findByTotalNoOfBeds(@Param("totalNoOfBeds") String totalNoOfBeds);
	
	@Query(value="SELECT * FROM propertypg WHERE total_No_Of_Beds = :totalNoOfBeds", nativeQuery = true)
	List<PropertyPG> findByTotalNoOfBeds(@Param("totalNoOfBeds") String totalNoOfBeds);

	@Query(value="SELECT * FROM propertypg WHERE available_For = :availableFor", nativeQuery = true)
	List<PropertyPG> findByAvailableFor(@Param("availableFor") String availableFor);

	 @Query(value = "SELECT * FROM propertypg WHERE locality = :locality AND available_for = :availableFor AND one_person_rent <= :onePersonRent", nativeQuery = true)
	List<PropertyPG> findLocalityAvailableForRent(String locality, String availableFor, int onePersonRent);

}
