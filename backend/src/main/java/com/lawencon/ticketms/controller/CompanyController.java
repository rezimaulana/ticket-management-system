package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.company.CompanyDeleteResDto;
import com.lawencon.ticketms.dto.company.CompanyInsertReqDto;
import com.lawencon.ticketms.dto.company.CompanyInsertResDto;
import com.lawencon.ticketms.dto.company.CompanyListResDto;
import com.lawencon.ticketms.dto.company.CompanyResDto;
import com.lawencon.ticketms.dto.company.CompanyUpdateReqDto;
import com.lawencon.ticketms.dto.company.CompanyUpdateResDto;
import com.lawencon.ticketms.service.CompanyService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public ResponseEntity<CompanyListResDto> getAll() {
		final CompanyListResDto result = companyService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CompanyResDto> getById(@PathVariable("id") Long id){
		final CompanyResDto result = companyService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CompanyInsertResDto> insert(@RequestBody CompanyInsertReqDto data){
		final CompanyInsertResDto result = companyService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<CompanyUpdateResDto> update(@RequestBody CompanyUpdateReqDto data){
		final CompanyUpdateResDto result = companyService.update(data);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<CompanyDeleteResDto> delete(@PathVariable("id") Long id) {
		final CompanyDeleteResDto result = companyService.deleteById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
