package com.main.gharrImaratApp.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.gharrImaratApp.model.PropertyRentAndBuy;

public interface PropertyRentAndBuyRepository extends JpaRepository<PropertyRentAndBuy, UUID>{

	@Query(value = "SELECT * FROM property_rent_and_buy WHERE user_agent1id = :userAgent1Id OR user_agent2id = :userAgent2Id", nativeQuery = true)
    List<PropertyRentAndBuy> findByUserAgent1IdOrUserAgent2Id(UUID userAgent1Id, UUID userAgent2Id);
	
	 @Query(value = "SELECT * FROM property_rent_and_buy WHERE property_locality = :location AND flatbhk = :flatBHK AND price < :price AND for_sale_or_rent_string = :forSaleOrRentString" , nativeQuery = true)
	    List<PropertyRentAndBuy> findByLocationAndFlatBHKAndPriceLessThan(@Param("location") String location, @Param("flatBHK") String flatBHK, @Param("price") int price,@Param("forSaleOrRentString") String forSaleOrRentString);
	    
	@Query(value = "SELECT * FROM property_rent_and_buy WHERE price < ?1", nativeQuery = true)
    List<PropertyRentAndBuy> findByPriceLessThan(int price);

	@Query(value = "SELECT * FROM useragentrealestate.property_rent_and_buy WHERE propertytype = :propertyTYPE", nativeQuery = true)
    List<PropertyRentAndBuy> findByPropertyType(@Param("propertyTYPE") String propertyTYPE);

	@Query(value = "SELECT * FROM useragentrealestate.property_rent_and_buy WHERE furnishing = :furnishing", nativeQuery = true)
    List<PropertyRentAndBuy> findByFurnishing(@Param("furnishing") String furnishing);

	@Query(value = "SELECT * FROM useragentrealestate.property_rent_and_buy WHERE number_of_bathroom = :numberOfBathroom", nativeQuery = true)
    List<PropertyRentAndBuy> findByNumberOfBathroom(@Param("numberOfBathroom") int numberOfBathroom);

	@Query(value = "SELECT * FROM property_rent_and_buy WHERE property_Locality= :propertyLocality", nativeQuery=true)
	List<PropertyRentAndBuy> findByPropertyLocality(@Param("propertyLocality") String propertyLocality);

	
	@Query(value="SELECT * FROM property_rent_and_buy WHERE " +
					"(:propertyLocality is null OR property_locality = :propertyLocality) And" +
					"(:price is null or price < :price) And"+
					"(:propertyType is null OR propertytype = :propertyType) And"+
					"(:furnishing IS NULL OR furnishing = :furnishing) and " +
					"(:forSaleOrRentString IS NULL OR for_sale_or_rent_string = :forSaleOrRentString) and " +
					"(:facing IS NULL OR facing = :facing) and " +
					"(:constructionPhase IS NULL OR construction_phase = :constructionPhase) and " +
					"(:flatBHK IS NULL OR flatbhk = :flatBHK)" ,nativeQuery = true
					)
	List<PropertyRentAndBuy> findByFilters( @Param("propertyLocality")String propertyLocality,  @Param("price") Integer price, @Param("propertyType")String propertyType,  @Param("furnishing")String furnishing,
			 @Param("forSaleOrRentString")String forSaleOrRentString,@Param("facing")String facing,@Param("constructionPhase")String constructionPhase, @Param("flatBHK")String flatBHK);

}
