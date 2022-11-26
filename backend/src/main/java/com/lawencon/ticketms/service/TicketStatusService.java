package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.ticketstatus.TicketStatusListResDto;
import com.lawencon.ticketms.dto.ticketstatus.TicketStatusResDto;

public interface TicketStatusService {
	TicketStatusListResDto getAll();
	TicketStatusResDto getById(Long id);
	TicketStatusResDto getByCode(String code);
}
