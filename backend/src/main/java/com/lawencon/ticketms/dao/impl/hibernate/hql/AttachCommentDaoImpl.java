package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.AttachCommentDao;
import com.lawencon.ticketms.model.AttachmentComment;

@Repository
@Profile("hql")
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

	@Override
	public List<AttachmentComment> getAll()  {
		final String sql = " SELECT ac "
				+ "	FROM AttachmentComment ac ";
		final List<AttachmentComment> attachmentComment = this.em.createQuery(sql, AttachmentComment.class).getResultList();
		return attachmentComment;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM AttachmentComment WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public List<AttachmentComment> getAllIdComment(long id) {
		final String sql = " SELECT ac "
				+ "	FROM AttachmentComment ac "
				+ "INNER JOIN FETCH ac.file f "
				+ "INNER JOIN FETCH ac.comment c "
				+ "WHERE c.id = :id ";
		final List<AttachmentComment> result = this.em.createQuery(sql, AttachmentComment.class)
				.setParameter("id", id).getResultList();
		return result;
	}

}
