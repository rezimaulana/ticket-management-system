package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.CommentDao;
import com.lawencon.ticketms.model.Comment;
import com.lawencon.ticketms.repository.jpql.CommentRepositoryJpql;

@Repository
@Profile("datajpql")
public class CommentDaoImpl extends BaseDaoImpl implements CommentDao{
	
	@Autowired
	private CommentRepositoryJpql repository;
	
	@Override
	public Comment insert(final Comment data)  {
		return repository.save(data);
	}

	@Override
	public Comment update(final Comment data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<Comment> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<Comment> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public List<Comment> getAllIdTicket(final Long id)  {
		return repository.getAllIdTicket(id);
	}

}
