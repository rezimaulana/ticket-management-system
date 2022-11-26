package com.lawencon.ticketms.dto.ticket;

public class TicketUpdateResDto {
	private TicketUpdateDataResDto data;
	private String message;
	public TicketUpdateDataResDto getData() {
		return data;
	}
	public void setData(TicketUpdateDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
