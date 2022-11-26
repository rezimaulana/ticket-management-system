package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.AttachCommentDao;
import com.lawencon.ticketms.model.AttachmentComment;
import com.lawencon.ticketms.repository.jpql.AttachCommentRepositoryJpql;

@Repository
@Profile("datajpql")
public class AttachCommentDaoImpl extends BaseDaoImpl implements AttachCommentDao{
	
	@Autowired
	private AttachCommentRepositoryJpql repository;
	
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
		return repository.findById(id);
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
