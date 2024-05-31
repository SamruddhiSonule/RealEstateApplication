package com.main.gharrImaratApp.controller;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.gharrImaratApp.model.EnquiryBox;
import com.main.gharrImaratApp.service.EnquiryBoxService;


@RestController
@CrossOrigin("*")
public class EnquiryBoxController {

	@Autowired
	EnquiryBoxService enquiryBoxService;
	//post Enquiries By Ids	
	@PostMapping("/enquiryBox/agent/{userAgent1ID}/{userAgent2ID}")
	public ResponseEntity<EnquiryBox> storeEnquiry(@PathVariable UUID userAgent1ID,@PathVariable UUID userAgent2ID,@RequestBody EnquiryBox enquiryBox){
		
		
		
	EnquiryBox enquiryBox1 =	enquiryBoxService.storeEnquiry(userAgent1ID,userAgent2ID,enquiryBox);
		return new  ResponseEntity<EnquiryBox>(enquiryBox1,HttpStatus.OK);
	}
//get Enquiries by IDs	
	@GetMapping("/enquiryBox/agent/getall/{userAgent1ID}/{userAgent2ID}")
	public ResponseEntity< List<EnquiryBox>> getAllEnquiriesByUIDs(@PathVariable UUID userAgent1ID,@PathVariable UUID userAgent2ID)
	{
	List<EnquiryBox> list=	enquiryBoxService.getAllEnquiriesByUIDs(userAgent1ID,userAgent2ID);
	return new  ResponseEntity< List<EnquiryBox>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/enquiryBox/agent/status/{enquiryBoxID}/{status}")
	public ResponseEntity<EnquiryBox> storeEnquiryStatus(@PathVariable UUID enquiryBoxID,@PathVariable String status){
		
	EnquiryBox enquiryBox1 =	enquiryBoxService.storeEnquiryStatus(enquiryBoxID,status);
		return new  ResponseEntity<EnquiryBox>(enquiryBox1,HttpStatus.OK);
}//
}