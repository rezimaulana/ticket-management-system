package com.lawencon.ticketms.dto.productcustomer;

import java.util.List;

public class ProductCustomerInsertListReqDto {
	
	private List<ProductCustomerInsertReqDto> data;

	public List<ProductCustomerInsertReqDto> getData() {
		return data;
	}

	public void setData(List<ProductCustomerInsertReqDto> data) {
		this.data = data;
	}
	
}
