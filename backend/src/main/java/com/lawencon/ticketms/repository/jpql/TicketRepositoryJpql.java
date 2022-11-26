package com.lawencon.ticketms.repository.jpql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.Ticket;

@Repository
public interface TicketRepositoryJpql extends JpaRepository<Ticket, Long>{
	int removeById(Long id);
	@Query("SELECT t "
			+ "FROM Ticket t "
			+ "INNER JOIN FETCH t.ticketPriority tp "
			+ "INNER JOIN FETCH t.ticketStatus ts "
			+ "INNER JOIN FETCH t.productCustomer pc "
			+ "INNER JOIN FETCH pc.product p "
			+ "INNER JOIN FETCH pc.user u "
			+ "WHERE u.id = :id")
	List<Ticket> getAllIdCust(@Param("id") Long id);
	@Query("SELECT t "
			+ "FROM Ticket t "
			+ "INNER JOIN FETCH t.ticketPriority tp "
			+ "INNER JOIN FETCH t.ticketStatus ts "
			+ "INNER JOIN FETCH t.productCustomer pc "
			+ "INNER JOIN FETCH pc.product p "
			+ "INNER JOIN FETCH pc.user u "
			+ "INNER JOIN FETCH u.picId pic "
			+ "WHERE pic.id = :id")
	List<Ticket> getAllIdPic(@Param("id") Long id);
}
