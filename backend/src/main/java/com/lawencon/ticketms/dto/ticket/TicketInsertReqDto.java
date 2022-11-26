package com.lawencon.ticketms.dto.ticket;

import java.util.List;

public class TicketInsertReqDto {
	private String title;
	private String content;
	private String ticketPriorityCode;
	private Long productCustomerId;
	private List<FileInsertReqDto> file;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTicketPriorityCode() {
		return ticketPriorityCode;
	}
	public void setTicketPriorityCode(String ticketPriorityCode) {
		this.ticketPriorityCode = ticketPriorityCode;
	}
	public Long getProductCustomerId() {
		return productCustomerId;
	}
	public void setProductCustomerId(Long productCustomerId) {
		this.productCustomerId = productCustomerId;
	}
	public List<FileInsertReqDto> getFile() {
		return file;
	}
	public void setFile(List<FileInsertReqDto> file) {
		this.file = file;
	}
}
