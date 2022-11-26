package com.lawencon.ticketms.constant;

public enum TicketPriorityConst {
	HIGH("P01", "High"), MEDIUM("P02", "Medium"), LOW("P03", "Low");

	private final String priorityCodeEnum;
	private final String priorityNameEnum;
	
	TicketPriorityConst(final String priorityCodeEnum, final String priorityNameEnum) {
		this.priorityCodeEnum = priorityCodeEnum;
		this.priorityNameEnum = priorityNameEnum;
		}

	public String getPriorityCodeEnum() {
		return priorityCodeEnum;
	}

	public String getPriorityNameEnum() {
		return priorityNameEnum;
	}
}
