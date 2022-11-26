package com.lawencon.ticketms.repository.jpql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.TicketStatus;

@Repository
public interface TicketStatusRepositoryJpql extends JpaRepository<TicketStatus, Long>{
	int removeById(Long id);
	@Query(" SELECT ts "
			+ "FROM TicketStatus ts "
			+ "where lower(statusCode) = lower(:code) ")
	Optional<TicketStatus> getByCode(@Param("code") String code);
}
