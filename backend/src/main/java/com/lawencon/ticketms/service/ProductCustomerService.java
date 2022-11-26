package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.productcustomer.ProductCustomerDeleteResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerInsertListReqDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerInsertResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerListResDto;
import com.lawencon.ticketms.dto.productcustomer.ProductCustomerResDto;

public interface ProductCustomerService {
	ProductCustomerInsertResDto insert(ProductCustomerInsertListReqDto data);
	ProductCustomerResDto getById(Long id);
	ProductCustomerListResDto getAll();
	ProductCustomerDeleteResDto deleteById(Long id);
	ProductCustomerListResDto getAllIdCust(Long id);
}
