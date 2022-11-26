package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.productcustomer.ProductCustomerDeleteResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerInsertListReqDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerInsertResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerListResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerResDto;
import com.lawencon.ticketms.service.ProductCustomerService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("products_cust")
public class ProductCustomerController {
	
	@Autowired
	private ProductCustomerService productCustomerService;
		
	@GetMapping
	public ResponseEntity<ProductCustomerListResDto> getAll() {
		final ProductCustomerListResDto result = productCustomerService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProductCustomerResDto> getById(@PathVariable("id") Long id){
		final ProductCustomerResDto result = productCustomerService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("customer/{id}")
	public ResponseEntity<ProductCustomerListResDto> getAllIdCust(@PathVariable("id") Long id){
		final ProductCustomerListResDto result = productCustomerService.getAllIdCust(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductCustomerInsertResDto> insert(@RequestBody ProductCustomerInsertListReqDto data){
		final ProductCustomerInsertResDto result = productCustomerService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ProductCustomerDeleteResDto> delete(@PathVariable("id") Long id) {
		final ProductCustomerDeleteResDto result = productCustomerService.deleteById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
