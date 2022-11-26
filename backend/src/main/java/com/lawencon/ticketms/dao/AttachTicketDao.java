package com.lawencon.ticketms.dao;

import java.util.List;

import com.lawencon.ticketms.model.AttachmentTicket;

public interface AttachTicketDao extends BaseDao<AttachmentTicket>{
	List<AttachmentTicket> getAllIdTicket(long id);
}
