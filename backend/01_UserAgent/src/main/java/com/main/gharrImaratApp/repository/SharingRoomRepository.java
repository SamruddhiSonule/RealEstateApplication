package com.main.gharrImaratApp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.gharrImaratApp.model.SharingRooms;

public interface SharingRoomRepository extends JpaRepository<SharingRooms, UUID>{

	@Query(value = " SELECT * FROM sharing_rooms WHERE sharing = :sharing", nativeQuery = true)
	List<SharingRooms> findBySharing(@Param("sharing") String sharing);

	
	@Query(value = "SELECT * FROM useragentrealestate.sharing_rooms WHERE food_Availability = :foodAvailability", nativeQuery = true)
	List<SharingRooms> findByFoodAvailability(@Param("foodAvailability") String foodAvailability);

	@Query(value = "SELECT * FROM useragentrealestate.sharing_rooms WHERE location = :location AND availableFor = :availableFor AND rent = :rent", nativeQuery = true)
	List<SharingRooms> findByLocationAndAvailableForAndRent(String location, String availableFor, int rent);

	@Query(value = "SELECT * FROM sharing_rooms WHERE rent <= :rent", nativeQuery = true)
	List<SharingRooms> findByRentLessThan(int rent);
}
