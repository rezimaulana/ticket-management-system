package com.lawencon.ticketms.dao;

import java.util.List;

import com.lawencon.ticketms.model.Ticket;

public interface TicketDao extends BaseDao<Ticket>{
	List<Ticket> getAllIdCust(Long id);
	List<Ticket> getAllIdPic(Long id);
	Ticket updateStatus(Ticket data);
}
