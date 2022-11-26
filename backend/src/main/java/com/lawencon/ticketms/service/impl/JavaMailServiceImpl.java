package com.lawencon.ticketms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.pojo.SendEmailPojo;
import com.lawencon.ticketms.service.JavaMailService;

@Service
public class JavaMailServiceImpl implements JavaMailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(final SendEmailPojo createdAccountPojo) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(createdAccountPojo.getEmail());
		
		msg.setSubject(createdAccountPojo.getSubject());
		msg.setText(createdAccountPojo.getBody());
		javaMailSender.send(msg);
	}

}
