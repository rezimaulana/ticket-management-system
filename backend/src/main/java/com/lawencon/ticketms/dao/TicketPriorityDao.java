package com.lawencon.ticketms.dao;

import java.util.Optional;

import com.lawencon.ticketms.model.TicketPriority;

public interface TicketPriorityDao extends BaseDao<TicketPriority>{
	Optional<TicketPriority> getByCode(String code);
}
