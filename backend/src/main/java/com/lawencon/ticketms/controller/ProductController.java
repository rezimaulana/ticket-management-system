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

import com.lawencon.ticketms.dto.product.ProductDeleteResDto;
import com.lawencon.ticketms.dto.product.ProductInsertReqDto;
import com.lawencon.ticketms.dto.product.ProductInsertResDto;
import com.lawencon.ticketms.dto.product.ProductListResDto;
import com.lawencon.ticketms.dto.product.ProductResDto;
import com.lawencon.ticketms.dto.product.ProductUpdateReqDto;
import com.lawencon.ticketms.dto.product.ProductUpdateResDto;
import com.lawencon.ticketms.service.ProductService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
//	@PreAuthorize("hasAuthority('SA1')")
	public ResponseEntity<ProductListResDto> getAll() {
		final ProductListResDto result = productService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProductResDto> getById(@PathVariable("id") Long id){
		final ProductResDto result = productService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductInsertResDto> insert(@RequestBody ProductInsertReqDto data){
		final ProductInsertResDto result = productService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ProductUpdateResDto> update(@RequestBody ProductUpdateReqDto data){
		final ProductUpdateResDto result = productService.update(data);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ProductDeleteResDto> delete(@PathVariable("id") Long id) {
		final ProductDeleteResDto result = productService.deleteById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
