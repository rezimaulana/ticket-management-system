package com.lawencon.ticketms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="companies", uniqueConstraints = {
		@UniqueConstraint(
				name = "companies_ck",
				columnNames = {"company_code", "company_name"}
		)
})
public class Company extends BaseModel{
	
	@Column(name = "company_code", unique=true, nullable=false, length=10)
	private String companyCode;
	@Column(name = "company_name", nullable=false, length=100)
	private String companyName;
	@Column(name = "company_address", nullable=false)
	private String companyAddress;
	@ManyToOne
	@JoinColumn(name = "photo_id")
	private File file;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(final String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(final String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
