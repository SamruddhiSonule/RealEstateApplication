package com.main.gharrImaratApp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.main.gharrImaratApp.model.PropertyRentAndBuy;
import com.main.gharrImaratApp.model.UserAgent;

public interface UserAgentServiceInterface {

	public UserAgent addUserAgentRecord(UserAgent userAgent);

	public Optional<UserAgent> getSingleUserAgentRecord(UUID userAgent1ID, UUID userAgent2ID);

	public Iterable<UserAgent> viewAllUserAgentRecords();

	public UserAgent upadteUserAgentRecord(UUID userAgent1ID, UUID userAgent2ID, PropertyRentAndBuy properties);

	public UserAgent deleteAgentRecord(UUID userAgent1ID, UUID userAgent2ID);

	public UserAgent getSingleUserAgentRecordByName(String userAgentPassword, String userAgentEmail);

	public List<PropertyRentAndBuy> getPropertyByRentAndBuy(UUID userAgent1ID, UUID userAgent2ID);

	public UserAgent updateUserAgentRecord(UUID userAgent1ID, UUID userAgent2ID, UserAgent userAgent);

	

}
