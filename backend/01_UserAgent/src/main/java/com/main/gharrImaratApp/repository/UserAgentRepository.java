package com.main.gharrImaratApp.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.UserAgent;
import com.main.gharrImaratApp.model.UserAgentId;

public interface UserAgentRepository extends JpaRepository<UserAgent, UserAgentId>{


	
	@Query(value = "SELECT * FROM user_agent WHERE user_agent1id = :userAgent1ID AND user_agent2id = :userAgent2ID", nativeQuery = true)
    Optional<UserAgent> findByUserAgent(UUID userAgent1ID, UUID userAgent2ID);

	
	@Query(value = "SELECT * FROM user_agent WHERE user_agent_password = :userAgentPassword AND user_agent_email = :userAgentEmail LIMIT 1", nativeQuery = true)
	Optional<UserAgent> findByUserAgentPasswordAndUserAgentEmail(@Param("userAgentPassword") String userAgentPassword, @Param("userAgentEmail") String userAgentEmail);


	@Query("SELECT ua.propertyRentAndBuyList FROM UserAgent ua WHERE ua.userAgent1ID = :userAgent1ID AND ua.userAgent2ID = :userAgent2ID")
    List<PropertyRentAndBuy> findPropertyRentAndBuyByUserAgent(UUID userAgent1ID, UUID userAgent2ID);
}


	



	

