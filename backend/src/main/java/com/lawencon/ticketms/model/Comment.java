package com.lawencon.ticketms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment extends BaseModel{
	
	@Column(name = "comments", nullable=false)
	private String comments;
	@Column(name = "comment_id")
	private Long comment;
	@ManyToOne
	@JoinColumn(name = "ticket_id", nullable=false)
	private Ticket ticket;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false)
	private User user;
	
	public String getComments() {
		return comments;
	}
	public void setComments(final String comments) {
		this.comments = comments;
	}
	public Long getComment() {
		return comment;
	}
	public void setComment(Long comment) {
		this.comment = comment;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(final Ticket ticket) {
		this.ticket = ticket;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
