package com.lawencon.ticketms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseModel{
	
	@Column(name = "email", nullable=false, unique=true, length=200)
	private String email;
	@Column(name = "password", nullable=false)
	private String password;
	@Column(name = "fullname", nullable=false, length=100)
	private String fullname;
	@ManyToOne
	@JoinColumn(name = "pic_id")
	private User picId;
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	@ManyToOne
	@JoinColumn(name = "role_id", nullable=false)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "photo_id")
	private File file;

	public String getEmail() {
		return email;
	}
	public void setEmail(final String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(final String fullname) {
		this.fullname = fullname;
	}
	public Company getCompany() {
		return company;
	}
	public User getPicId() {
		return picId;
	}
	public void setPicId(User picId) {
		this.picId = picId;
	}
	public void setCompany(final Company company) {
		this.company = company;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(final Role role) {
		this.role = role;
	}
	public File getFile() {
		return file;
	}
	public void setFile(final File file) {
		this.file = file;
	}
}
