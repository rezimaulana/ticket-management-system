package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.product.ProductDeleteResDto;
import com.lawencon.ticketms.dto.product.ProductInsertReqDto;
import com.lawencon.ticketms.dto.product.ProductInsertResDto;
import com.lawencon.ticketms.dto.product.ProductListResDto;
import com.lawencon.ticketms.dto.product.ProductResDto;
import com.lawencon.ticketms.dto.product.ProductUpdateReqDto;
import com.lawencon.ticketms.dto.product.ProductUpdateResDto;

public interface ProductService{
	ProductInsertResDto insert(ProductInsertReqDto data);
	ProductUpdateResDto update(ProductUpdateReqDto data);
	ProductResDto getById(Long id);
	ProductListResDto getAll();
	ProductDeleteResDto deleteById(Long id);
	
}
