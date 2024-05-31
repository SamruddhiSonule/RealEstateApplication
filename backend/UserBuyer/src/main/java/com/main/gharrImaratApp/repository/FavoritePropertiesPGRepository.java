package com.main.gharrImaratApp.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.gharrImaratApp.model.FavoritePropertiesPG;

public interface FavoritePropertiesPGRepository extends JpaRepository<FavoritePropertiesPG, UUID>{

	@Query(value = "SELECT * FROM userbuyer.favorite_propertiespg WHERE propertypgid =:propertyPGID", nativeQuery = true)
	Optional<FavoritePropertiesPG> findByPropertyPGID(UUID propertyPGID);

	@Query(value = "SELECT * FROM userbuyer.favorite_propertiespg WHERE total_no_of_beds =:totalNoOfBeds", nativeQuery = true)
	List<FavoritePropertiesPG> findByTotalNoOfBeds(String totalNoOfBeds);

	@Query(value = "SELECT * FROM userbuyer.favorite_propertiespg WHERE available_for =:availableFor", nativeQuery = true)
	List<FavoritePropertiesPG> findByAvailableFor(String availableFor);

}
