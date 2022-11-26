package com.lawencon.ticketms.repository.nativequery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.Comment;

@Repository
public interface CommentRepositoryNative extends JpaRepository<Comment, Long>{
	int removeById(Long id);
	
	@Query(value="SELECT * "
			+ "FROM comments c "
			+ "INNER JOIN tickets t ON c.ticket_id = t.id "
			+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
			+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
			+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
			+ "INNER JOIN products p ON pc.product_id = p.id "
			+ "INNER JOIN users u ON u.id = c.user_id "
			+ "LEFT JOIN files f ON f.id = u.photo_id "
			+ "WHERE c.ticket_id = :id "
			+ "ORDER BY c.created_at DESC", nativeQuery=true)
	List<Comment> getAllIdTicket(@Param("id") final Long id); 
}
