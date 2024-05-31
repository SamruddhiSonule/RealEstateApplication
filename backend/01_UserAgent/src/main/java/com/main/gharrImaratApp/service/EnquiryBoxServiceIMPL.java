package com.main.gharrImaratApp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.gharrImaratApp.model.EnquiryBox;
import com.main.gharrImaratApp.model.UserAgent;
import com.main.gharrImaratApp.repository.EnquiryBoxRepo;
import com.main.gharrImaratApp.repository.UserAgentRepository;

@Service
public class EnquiryBoxServiceIMPL implements EnquiryBoxService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	UserAgentRepository userAgentRepository;
	
	@Autowired
	EnquiryBoxRepo enquiryBoxRepo;
	
	
	@Override
	public EnquiryBox storeEnquiry(UUID userAgent1ID, UUID userAgent2ID,EnquiryBox enquiryBox) {
		
  Optional<UserAgent> userOptional=		userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
		if(userOptional.isPresent()) {
			UserAgent userAgent = userOptional.get();
			LocalTime localTime=LocalTime.now();
			LocalDate localDate=LocalDate.now();
			String localTme=localTime.toString();
			String localDte=localDate.toString();
			enquiryBox.setLocaTimeStamp(localTme);
			enquiryBox.setLocalDate(localDte);
			userAgent.getEnquiryBoxs().add(enquiryBox);
			
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(enquiryBox.getMailSender());
			simpleMailMessage.setTo(enquiryBox.getMailReciever());
			simpleMailMessage.setSubject(enquiryBox.getSubject());
			simpleMailMessage.setText(enquiryBox.getEnquiryMessage());
			mailSender.send(simpleMailMessage);
			
			
			userAgentRepository.save(userAgent);
			return enquiryBox;
		}
		return null;
	}


	@Override
	public List<EnquiryBox> getAllEnquiriesByUIDs(UUID userAgent1ID, UUID userAgent2ID) {
		 Optional<UserAgent> userOptional=		userAgentRepository.findByUserAgent(userAgent1ID, userAgent2ID);
			if(userOptional.isPresent()) {
				UserAgent userAgent = userOptional.get();
				List<EnquiryBox> list=userAgent.getEnquiryBoxs();
				return list;
			}
		return null;
	}


	@Override
	public EnquiryBox storeEnquiryStatus(UUID enquiryBoxID, String status) {
	Optional<EnquiryBox> prOptional=	enquiryBoxRepo.findById(enquiryBoxID);
	if(prOptional.isPresent()) {
	EnquiryBox enquiryBox2=	prOptional.get();
	enquiryBox2.setStatus(status);
	System.out.println(status);
	enquiryBoxRepo.save(enquiryBox2);
	return enquiryBox2;
	}
		return null;
	}

}//
