package com.lawencon.ticketms.constant;

public enum TicketStatusConst {
	STATOP("T01", "Open"), STATCL("T02", "Closed"), STATRO("T03", "Re-Open");

	private final String statusCodeEnum;
	private final String statusNameEnum;
	
	TicketStatusConst(final String statusCodeEnum, final String statusNameEnum) {
		this.statusCodeEnum = statusCodeEnum;
		this.statusNameEnum = statusNameEnum;
		}

	public String getStatusCodeEnum() {
		return this.statusCodeEnum;
	}

	public String getStatusNameEnum() {
		return this.statusNameEnum;
	}
}
