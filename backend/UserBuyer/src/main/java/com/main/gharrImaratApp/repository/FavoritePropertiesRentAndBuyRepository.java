package com.main.gharrImaratApp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;

@Repository
public interface FavoritePropertiesRentAndBuyRepository extends JpaRepository<FavoritePropertiesRentAndBuy, UUID>{

}
