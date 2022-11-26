package com.lawencon.ticketms.dto.ticket;

public class TicketUpdateReqDto {
	private Long id;
	private Integer ver;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}
}
