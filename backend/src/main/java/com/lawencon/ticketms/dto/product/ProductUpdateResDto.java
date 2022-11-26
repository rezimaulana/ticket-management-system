package com.lawencon.ticketms.dto.product;

public class ProductUpdateResDto {
	private ProductUpdateDataResDto data;
	private String message;
	public ProductUpdateDataResDto getData() {
		return data;
	}
	public void setData(ProductUpdateDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
