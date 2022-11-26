package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.ticketpriority.TicketPriorityListResDto;
import com.lawencon.ticketms.dto.ticketpriority.TicketPriorityResDto;
import com.lawencon.ticketms.service.TicketPriorityService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("ticket_priority")
public class TicketPriorityController {
	
	@Autowired
	private TicketPriorityService ticketPriorityService;
	
	@GetMapping
	public ResponseEntity<TicketPriorityListResDto> getAll() {
		final TicketPriorityListResDto result = ticketPriorityService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TicketPriorityResDto> getById(@PathVariable("id") Long id){
		final TicketPriorityResDto result = ticketPriorityService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("code/{code}")
	public ResponseEntity<TicketPriorityResDto> getByCode(@PathVariable("code") String code){
		final TicketPriorityResDto result = ticketPriorityService.getByCode(code);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
