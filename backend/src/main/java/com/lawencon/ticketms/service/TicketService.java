package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.ticket.TicketInsertReqDto;
import com.lawencon.ticketms.dto.ticket.TicketInsertResDto;
import com.lawencon.ticketms.dto.ticket.TicketListResDto;
import com.lawencon.ticketms.dto.ticket.TicketResDto;
import com.lawencon.ticketms.dto.ticket.TicketUpdateReqDto;
import com.lawencon.ticketms.dto.ticket.TicketUpdateResDto;

public interface TicketService {
	TicketInsertResDto insert(TicketInsertReqDto data);
	TicketResDto getById(Long id);
	TicketListResDto getAll();
	
	TicketListResDto getAllIdCust(Long id);
	TicketListResDto getAllIdPic(Long id);
	TicketUpdateResDto updateStatus(TicketUpdateReqDto data);
}
