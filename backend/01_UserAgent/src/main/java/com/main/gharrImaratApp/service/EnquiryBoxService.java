package com.main.gharrImaratApp.service;

import java.util.List;
import java.util.UUID;

import com.main.gharrImaratApp.model.EnquiryBox;

public interface EnquiryBoxService {

	EnquiryBox storeEnquiry(UUID userAgent1ID, UUID userAgent2ID, EnquiryBox enquiryBox);

	List<EnquiryBox> getAllEnquiriesByUIDs(UUID userAgent1ID, UUID userAgent2ID);

	EnquiryBox storeEnquiryStatus(UUID enquiryBoxID, String status);

}//
