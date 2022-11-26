package com.lawencon.ticketms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="files")
public class File extends BaseModel {
	
	@Column(name = "file_code", nullable=false)
	private String fileCode;
	@Column(name = "file_ext", nullable=false)
	private String fileExt;
	
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(final String fileCode) {
		this.fileCode = fileCode;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(final String fileExt) {
		this.fileExt = fileExt;
	}
}
