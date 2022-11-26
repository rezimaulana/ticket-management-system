package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.role.RoleListResDto;
import com.lawencon.ticketms.dto.role.RoleResDto;
import com.lawencon.ticketms.service.RoleService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public ResponseEntity<RoleListResDto> getAll() {
		final RoleListResDto result = roleService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<RoleResDto> getById(@PathVariable("id") Long id){
		final RoleResDto result = roleService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}