package com.lawencon.ticketms.dto.company;

public class CompanyInsertResDto {
	private CompanyInsertDataResDto data;
	private String message;
	public CompanyInsertDataResDto getData() {
		return data;
	}
	public void setData(CompanyInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
