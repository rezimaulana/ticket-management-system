package com.lawencon.ticketms.dto.product;

public class ProductInsertResDto {
	private ProductInsertDataResDto data;
	private String message;
	public ProductInsertDataResDto getData() {
		return data;
	}
	public void setData(ProductInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
