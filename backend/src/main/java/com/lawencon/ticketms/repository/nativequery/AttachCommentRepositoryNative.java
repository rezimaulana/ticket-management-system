package com.lawencon.ticketms.repository.nativequery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.AttachmentComment;

@Repository
public interface AttachCommentRepositoryNative extends JpaRepository<AttachmentComment, Long>{
	int removeById(Long id);
	@Query(value="SELECT * "
			+ "FROM attachments_comment ac "
			+ "INNER JOIN files f ON f.id = ac.file_id "
			+ "WHERE ac.comment_id = :id", nativeQuery = true)
	List<AttachmentComment> getAllIdComment(@Param("id") long id);
}
