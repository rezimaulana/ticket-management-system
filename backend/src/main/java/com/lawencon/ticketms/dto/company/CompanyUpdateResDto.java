package com.lawencon.ticketms.dto.company;

public class CompanyUpdateResDto {
	private CompanyUpdateDataResDto data;
	private String message;
	public CompanyUpdateDataResDto getData() {
		return data;
	}
	public void setData(CompanyUpdateDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
