package com.lawencon.ticketms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tickets_priority")
public class TicketPriority extends BaseModel{
	
	@Column(name = "priority_code", nullable=false, unique=true, length=10)
	private String priorityCode;
	@Column(name = "priority", nullable=false, length=10)	
	private String priority;
	
	public String getPriorityCode() {
		return priorityCode;
	}
	public void setPriorityCode(final String priorityCode) {
		this.priorityCode = priorityCode;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(final String priority) {
		this.priority = priority;
	}
}
