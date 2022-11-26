package com.lawencon.ticketms.dto.comment;

import java.util.List;

public class CommentInsertReqDto {
	private String comments;
	private Long ticketId;
	private Long userId;
	private List<FileInsertReqDto> file;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<FileInsertReqDto> getFile() {
		return file;
	}
	public void setFile(List<FileInsertReqDto> file) {
		this.file = file;
	}
}
