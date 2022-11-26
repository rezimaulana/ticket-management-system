package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.attachmentticket.AttachmentTicketListResDto;
import com.lawencon.ticketms.dto.attachmentticket.AttachmentTicketResDto;

public interface AttachTicketService {
	AttachmentTicketResDto getById(Long id);
	AttachmentTicketListResDto getAll();
	AttachmentTicketListResDto getAllIdTicket(Long id);
}
