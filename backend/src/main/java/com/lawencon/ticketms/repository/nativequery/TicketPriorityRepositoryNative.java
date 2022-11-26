package com.lawencon.ticketms.repository.nativequery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.TicketPriority;

@Repository
public interface TicketPriorityRepositoryNative extends JpaRepository<TicketPriority, Long>{
	int removeById(Long id);
	@Query(value=" SELECT *  "
				+ "FROM tickets_priority where lower(priority_code) = lower(:code) ",nativeQuery=true)
	TicketPriority getByCode(@Param("code") final String code);
}
