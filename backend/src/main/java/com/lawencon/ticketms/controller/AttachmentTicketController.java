package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.attachmentticket.AttachmentTicketListResDto;
import com.lawencon.ticketms.dto.attachmentticket.AttachmentTicketResDto;
import com.lawencon.ticketms.service.AttachTicketService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("attachments_ticket")
public class AttachmentTicketController {
	
	@Autowired
	private AttachTicketService attachTicketService;
	
	@GetMapping
	public ResponseEntity<AttachmentTicketListResDto> getAll() {
		final AttachmentTicketListResDto result = attachTicketService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AttachmentTicketResDto> getById(@PathVariable("id") Long id){
		final AttachmentTicketResDto result = attachTicketService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("ticket/{id}")
	public ResponseEntity<AttachmentTicketListResDto> getAllIdTicket(@PathVariable("id") Long id) {
		final AttachmentTicketListResDto result = attachTicketService.getAllIdTicket(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
