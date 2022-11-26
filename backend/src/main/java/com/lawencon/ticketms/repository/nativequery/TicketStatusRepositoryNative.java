package com.lawencon.ticketms.repository.nativequery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.TicketStatus;

@Repository
public interface TicketStatusRepositoryNative extends JpaRepository<TicketStatus, Long>{
	int removeById(Long id);
	@Query(value=" SELECT * "
			+ "FROM tickets_status where lower(status_code) = lower(:code) ",nativeQuery=true)
	TicketStatus getByCode(@Param("code") final String code);
}
