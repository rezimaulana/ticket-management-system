package com.lawencon.ticketms.repository.nativequery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.AttachmentTicket;

@Repository
public interface AttachTicketRepositoryNative extends JpaRepository<AttachmentTicket, Long>{
	int removeById(Long id);
	@Query(value="SELECT * "
			+ "FROM attachments_ticket at "
			+ "WHERE at.ticket_id = :id ", nativeQuery = true)
	List<AttachmentTicket> getAllIdTicket(@Param("id") long id);
}
