package com.lawencon.ticketms.dto.user;

public class UserUpdateResDto {
	private UserUpdateDataResDto data;
	private String message;
	public UserUpdateDataResDto getData() {
		return data;
	}
	public void setData(UserUpdateDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
