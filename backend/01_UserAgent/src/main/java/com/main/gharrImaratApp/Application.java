package com.main.gharrImaratApp;

import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import jakarta.mail.internet.MimeMessage;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//    @Bean
//    JavaMailSender jms()
//	{
//		JavaMailSender javaMailSender=new JavaMailSender() {
//			
//			@Override
//			public void send(SimpleMailMessage... simpleMessages) throws MailException {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void send(MimeMessage... mimeMessages) throws MailException {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public MimeMessage createMimeMessage() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		return javaMailSender;
//	}
}
