package com.lawencon.ticketms.service;

import com.lawencon.ticketms.pojo.SendEmailPojo;

public interface JavaMailService {
	void sendEmail(SendEmailPojo createdAccountPojo);
}
