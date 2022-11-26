package com.lawencon.ticketms.repository.jpql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.AttachmentComment;

@Repository
public interface AttachCommentRepositoryJpql  extends JpaRepository<AttachmentComment, Long>{
	int removeById(Long id);
	@Query( " SELECT ac "
			+ "	FROM AttachmentComment ac "
			+ "INNER JOIN FETCH ac.file f "
			+ "INNER JOIN FETCH ac.comment c "
			+ "WHERE c.id = :id ")
	List<AttachmentComment> getAllIdComment(long id);
}
