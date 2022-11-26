package com.lawencon.ticketms.dto.user;

public class UserInsertResDto {
	private UserInsertDataResDto data;
	private String message;
	public UserInsertDataResDto getData() {
		return data;
	}
	public void setData(UserInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
