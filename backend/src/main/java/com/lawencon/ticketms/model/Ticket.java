package com.lawencon.ticketms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket extends BaseModel{
	
	@Column(name = "code", nullable=false, unique=true, length=50)
	private String code;
	@Column(name = "title", nullable=false, length=100)	
	private String title;
	@Column(name = "content", nullable=false)
	private String content;
	@ManyToOne
	@JoinColumn(name = "ticket_status_id", nullable=false)
	private TicketStatus ticketStatus;
	@ManyToOne
	@JoinColumn(name = "ticket_priority_id", nullable=false)
	private TicketPriority ticketPriority;
	@ManyToOne
	@JoinColumn(name = "product_cust_id", nullable=false)
	private ProductCustomer productCustomer;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(final String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(final String content) {
		this.content = content;
	}
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(final TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public TicketPriority getTicketPriority() {
		return ticketPriority;
	}
	public void setTicketPriority(final TicketPriority ticketPriority) {
		this.ticketPriority = ticketPriority;
	}
	public ProductCustomer getProductCustomer() {
		return productCustomer;
	}
	public void setProductCustomer(final ProductCustomer productCustomer) {
		this.productCustomer = productCustomer;
	}
}
