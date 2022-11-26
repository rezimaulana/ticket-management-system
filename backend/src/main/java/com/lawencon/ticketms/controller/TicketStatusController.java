package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.ticketstatus.TicketStatusListResDto;
import com.lawencon.ticketms.dto.ticketstatus.TicketStatusResDto;
import com.lawencon.ticketms.service.TicketStatusService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("ticket_status")
public class TicketStatusController {
	
	@Autowired
	private TicketStatusService ticketStatusService;
	
	@GetMapping
	public ResponseEntity<TicketStatusListResDto> getAll() {
		final TicketStatusListResDto result = ticketStatusService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TicketStatusResDto> getById(@PathVariable("id") Long id){
		final TicketStatusResDto result = ticketStatusService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("code/{code}")
	public ResponseEntity<TicketStatusResDto> getByCode(@PathVariable("code") String code){
		final TicketStatusResDto result = ticketStatusService.getByCode(code);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
