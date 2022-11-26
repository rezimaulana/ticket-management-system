package com.lawencon.ticketms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tickets_status")
public class TicketStatus extends BaseModel{
	
	@Column(name = "status_code", nullable=false, unique=true, length=10)
	private String statusCode;
	@Column(name = "status", nullable=false, length=10)
	private String status;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(final String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(final String status) {
		this.status = status;
	}
}
