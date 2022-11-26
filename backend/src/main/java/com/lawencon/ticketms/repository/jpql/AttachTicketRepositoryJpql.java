package com.lawencon.ticketms.repository.jpql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.AttachmentTicket;

@Repository
public interface AttachTicketRepositoryJpql  extends JpaRepository<AttachmentTicket, Long>{
	int removeById(Long id);
	@Query( " SELECT ac "
			+ "	FROM AttachmentTicket ac "
			+ "INNER JOIN FETCH ac.file f "
			+ "INNER JOIN FETCH ac.ticket t "
			+ "WHERE t.id = :id ")
	List<AttachmentTicket> getAllIdTicket(long id);
}
