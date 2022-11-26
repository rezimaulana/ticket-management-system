package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.ticket.TicketInsertReqDto;
import com.lawencon.ticketms.dto.ticket.TicketInsertResDto;
import com.lawencon.ticketms.dto.ticket.TicketListResDto;
import com.lawencon.ticketms.dto.ticket.TicketResDto;
import com.lawencon.ticketms.dto.ticket.TicketUpdateReqDto;
import com.lawencon.ticketms.dto.ticket.TicketUpdateResDto;
import com.lawencon.ticketms.service.TicketService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public ResponseEntity<TicketListResDto> getAll() {
		final TicketListResDto result = ticketService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<TicketUpdateResDto> update(@RequestBody TicketUpdateReqDto data){
		final TicketUpdateResDto result = ticketService.updateStatus(data);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TicketResDto> getById(@PathVariable("id") Long id){
		final TicketResDto result = ticketService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("customer/{id}")
	public ResponseEntity<TicketListResDto> getAllIdCust(@PathVariable("id") Long id) {
		final TicketListResDto result = ticketService.getAllIdCust(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("pic/{id}")
	public ResponseEntity<TicketListResDto> getAllIdPic(@PathVariable("id") Long id) {
		final TicketListResDto result = ticketService.getAllIdPic(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TicketInsertResDto> insert(@RequestBody TicketInsertReqDto data){
		final TicketInsertResDto result = ticketService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
		
}
