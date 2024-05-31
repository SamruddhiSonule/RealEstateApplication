package com.main.gharrImaratApp.servicei;

import java.util.Optional;
import java.util.UUID;

import com.main.gharrImaratApp.model.FavoritePropertiesRentAndBuy;
import com.main.gharrImaratApp.model.UserBuyer;

public interface UserBuyerService {

	public UserBuyer addUserBuyerDetails(UserBuyer userBuyer);

	public Iterable<UserBuyer> getAllUserBuyerDetails();

	public UserBuyer updateUserBuyerDetails(UUID userBuyer1ID, UUID userBuyer2ID, UserBuyer updatedUserBuyer);

	public void deleteUserBuyerRecord(UUID userBuyer1ID, UUID userBuyer2ID);

	public UserBuyer getSingleUserBuyerRecordByuserBuyer1ID_and_userBuyer2ID(UUID userBuyer1ID,
			UUID userBuyer2ID);

	public UserBuyer getSingleUserBuyerRecordByEmailAndPassword(String userBuyerEmail, String userBuyerPassword);



	


	

}
