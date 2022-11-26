package com.lawencon.ticketms.repository.jpql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.Comment;

@Repository
public interface CommentRepositoryJpql  extends JpaRepository<Comment, Long>{
	int removeById(Long id);
	@Query(value =  "SELECT c "
			+ "FROM Comment c "
			+ "INNER JOIN FETCH c.ticket t "
			+ "INNER JOIN FETCH t.ticketPriority tp "
			+ "INNER JOIN FETCH t.ticketStatus ts "
			+ "INNER JOIN FETCH t.productCustomer pc "
			+ "INNER JOIN FETCH pc.product p "
			+ "INNER JOIN FETCH c.user u "
			+ "LEFT JOIN u.file f "
			+ "WHERE t.id = :id "
			+ "ORDER BY c.createdAt DESC ")
	List<Comment> getAllIdTicket(@Param("id") final Long id);
}
