package com.lawencon.ticketms.constant;

public enum RoleConst {
	SUPERADMIN("SA1", "Super Admin"), PIC("PIC", "PIC"), CUST("CUS", "Customer"), SYS("SYS", "System");

	private final String roleCodeEnum;
	private final String roleNameEnum;
	
	RoleConst(final String roleCodeEnum, final String roleNameEnum) {
		this.roleCodeEnum = roleCodeEnum;
		this.roleNameEnum = roleNameEnum;
		}

	public String getRoleCodeEnum() {
		return this.roleCodeEnum;
	}

	public String getRoleNameEnum() {
		return this.roleNameEnum;
	}
}
