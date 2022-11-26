package com.lawencon.ticketms.dto.ticket;

public class TicketInsertResDto {
	private TicketInsertDataResDto data;
	private String message;
	public TicketInsertDataResDto getData() {
		return data;
	}
	public void setData(TicketInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
