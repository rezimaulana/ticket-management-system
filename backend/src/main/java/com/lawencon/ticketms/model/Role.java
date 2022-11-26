package com.lawencon.ticketms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="roles", uniqueConstraints = {
		@UniqueConstraint(
				name = "roles_ck",
				columnNames = {"role_code", "role_name"}
		)
})
public class Role extends BaseModel{
	
	@Column(name = "role_code", nullable=false, unique=true, length=10)
	private String roleCode;
	@Column(name = "role_name", nullable=false, length=20)
	private String roleName;
	
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(final String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(final String roleName) {
		this.roleName = roleName;
	}
}
