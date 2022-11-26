package com.lawencon.ticketms.dto.comment;

public class CommentInsertResDto {
	private CommentInsertDataResDto data;
	private String message;
	public CommentInsertDataResDto getData() {
		return data;
	}
	public void setData(CommentInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
