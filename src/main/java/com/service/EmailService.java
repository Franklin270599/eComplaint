package com.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;

	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMail(String toEmail, String subject, String message){
		//Creating a Simple mail message
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(toEmail);
		mail.setSubject(subject);
		mail.setText(message);
		
		mail.setFrom("frankieboy2759@gmail.com");
		//Sending mail message
		javaMailSender.send(mail);
		
	}

	
}