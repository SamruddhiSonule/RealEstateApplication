package com.main.gharrImaratApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.gharrImaratApp.model.EnquiryBox;

public interface EnquiryBoxRepo extends JpaRepository<EnquiryBox, UUID> {

}
