package com.main.gharrImaratApp.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.UserBuyer;
import com.main.gharrImaratApp.model.UserBuyerId;

@Repository
public interface UserBuyerRepository extends JpaRepository<UserBuyer, UserBuyerId>{


	@Query(value = "SELECT * FROM userbuyer.user_buyer WHERE user_buyer1id = :userBuyer1ID AND user_buyer2id = :userBuyer2ID", nativeQuery = true)
    public Optional<UserBuyer> findByUserBuyer1IDAndUserBuyer2ID(@Param("userBuyer1ID") UUID userBuyer1ID, @Param("userBuyer2ID") UUID userBuyer2ID);
	
    @Query(value="SELECT * FROM userbuyer.user_buyer WHERE user_buyer_email = :userBuyerEmail AND user_buyer_password = :userBuyerPassword", nativeQuery = true)
	public UserBuyer findByUserBuyerEmailAnduserBuyerPassword(String userBuyerEmail, String userBuyerPassword);


    
   
}
