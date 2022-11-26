package com.lawencon.ticketms.dao;

import java.util.Optional;

import com.lawencon.ticketms.model.TicketStatus;

public interface TicketStatusDao extends BaseDao<TicketStatus>{
	Optional<TicketStatus> getByCode(String code);
}
