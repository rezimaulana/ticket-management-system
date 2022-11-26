package com.lawencon.ticketms.repository.jpql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.TicketPriority;

@Repository
public interface TicketPriorityRepositoryJpql extends JpaRepository<TicketPriority, Long>{
	int removeById(Long id);
	@Query(" SELECT tp "
				+ "FROM TicketPriority tp "
				+ "where lower(tp.priorityCode) = lower(:code) ")
	Optional<TicketPriority> getByCode(@Param("code") String code);
}
