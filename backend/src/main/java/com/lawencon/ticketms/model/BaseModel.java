package com.lawencon.ticketms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "created_by", nullable=false)
	private Long createdBy;
	@Column(name = "created_at", nullable=false)
	private LocalDateTime createdAt;
	@Column(name = "updated_by")
	private Long updatedBy;
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	@Version
	private Integer ver;
	@Column(name = "is_active", nullable=false)
	private Boolean isActive;
	
	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
		this.isActive = true;
	}
	@PreUpdate
	public void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	public Long getId() {
		return id;
	}
	public void setId(final Long id) {
		this.id = id;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(final Long createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(final Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(final LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(final Boolean isActive) {
		this.isActive = isActive;
	}
}
