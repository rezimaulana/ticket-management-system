package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.AttachCommentDao;
import com.lawencon.ticketms.model.AttachmentComment;

@Repository
@Profile("native")
public class AttachCommentDaoImpl extends BaseDaoImpl implements AttachCommentDao{
	
	@Override
	public AttachmentComment insert(final AttachmentComment data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public AttachmentComment update(final AttachmentComment data)  {
		final AttachmentComment updateOne = this.em.merge(data);
		this.em.flush();
		return updateOne;
	}

	@Override
	public Optional<AttachmentComment> getById(final Long id)  {
		final AttachmentComment attachmentComment = this.em.find(AttachmentComment.class, id);
		em.detach(attachmentComment);
		final Optional<AttachmentComment> attachmentCommentOptional = Optional.ofNullable(attachmentComment);
		return attachmentCommentOptional;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttachmentComment> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM attachments_comment ac ";
		final List<AttachmentComment> attachmentComment = this.em.createNativeQuery(sql, AttachmentComment.class).getResultList();
		return attachmentComment;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM attachments_comment WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AttachmentComment> getAllIdComment(final long id) {
		final String sql = "SELECT * "
				+ "FROM attachments_comment ac "
				+ "INNER JOIN files f ON f.id = ac.file_id "
				+ "WHERE ac.comment_id = :id";
		final List<AttachmentComment> result = this.em.createNativeQuery(sql, AttachmentComment.class).setParameter("id", id).getResultList();
		return result;
	}
	
}