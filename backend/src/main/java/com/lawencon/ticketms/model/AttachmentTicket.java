package com.lawencon.ticketms.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attachments_ticket")
public class AttachmentTicket extends BaseModel{
	
	@ManyToOne
	@JoinColumn(name = "file_id", nullable=false)
	private File file;
	@ManyToOne
	@JoinColumn(name = "ticket_id", nullable=false)
	private Ticket ticket;
	
	public File getFile() {
		return file;
	}
	public void setFile(final File file) {
		this.file = file;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(final Ticket ticket) {
		this.ticket = ticket;
	}
}
