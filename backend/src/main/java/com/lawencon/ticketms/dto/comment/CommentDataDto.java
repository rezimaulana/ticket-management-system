package com.lawencon.ticketms.dto.comment;

import java.time.LocalDateTime;
import java.util.List;

public class CommentDataDto {
	private Long id;
	private String comments;
	private Long ticketId;
	private Long userId;
	private String fullname;
	private Long photoId;
	private LocalDateTime createdAt;
	private Integer ver;
	private List<Long> fileId;
	public Long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}
	public List<Long> getFileId() {
		return fileId;
	}
	public void setFileId(List<Long> fileId) {
		this.fileId = fileId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}
}
