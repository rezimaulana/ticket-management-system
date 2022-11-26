package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.AttachCommentDao;
import com.lawencon.ticketms.model.AttachmentComment;
import com.lawencon.ticketms.repository.nativequery.AttachCommentRepositoryNative;

@Repository
@Profile("datanative")
public class AttachCommentDaoImpl extends BaseDaoImpl implements AttachCommentDao{
	
	@Autowired
	private AttachCommentRepositoryNative repository;
	
	@Override
	public AttachmentComment insert(final AttachmentComment data)  {
		return repository.save(data);
	}

	@Override
	public AttachmentComment update(final AttachmentComment data)  {
		return repository.saveAndFlush(data);
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
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public List<AttachmentComment> getAllIdComment(final long id) {
		return repository.getAllIdComment(id);
	}

}