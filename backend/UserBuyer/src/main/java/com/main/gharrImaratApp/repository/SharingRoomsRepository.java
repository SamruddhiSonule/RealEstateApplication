package com.main.gharrImaratApp.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.gharrImaratApp.model.SharingRooms;

public interface SharingRoomsRepository extends JpaRepository<SharingRooms, UUID>{

	@Query(value="SELECT * FROM userbuyer.sharing_rooms WHERE  roomPGID= :roomPGID", nativeQuery = true)
	SharingRooms findByRoomPGID(UUID roomPGID);

	@Query(value="SELECT * FROM userbuyer.sharing_rooms WHERE location = :location AND available_for = :availableFor AND rent = :rent", nativeQuery = true)
	List<SharingRooms> findBySharingRoomsByLocationPriceBudget(String location, String availableFor, String rent);

	@Query(value="SELECT * FROM userbuyer.sharing_rooms WHERE sharing =:sharing", nativeQuery = true)
	List<SharingRooms> findByPropertySharingRoomsBySharing(String sharing);

	@Query(value="SELECT * FROM userbuyer.sharing_rooms WHERE rent =:rent", nativeQuery = true)
	List<SharingRooms> findByPropertySharingRoomsByRent(int rent);

	@Query(value="SELECT * FROM userbuyer.sharing_rooms WHERE food_availability =:foodAvailability", nativeQuery = true)
	List<SharingRooms> findByPropertySharingRoomsByFooDAailablity(String foodAvailability);

}


