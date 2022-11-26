package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.ticketpriority.TicketPriorityListResDto;
import com.lawencon.ticketms.dto.ticketpriority.TicketPriorityResDto;

public interface TicketPriorityService {
	TicketPriorityListResDto getAll();
	TicketPriorityResDto getById(Long id);
	TicketPriorityResDto getByCode(String code);
}
