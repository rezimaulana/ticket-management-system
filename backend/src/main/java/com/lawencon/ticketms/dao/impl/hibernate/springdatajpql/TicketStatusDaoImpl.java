package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketStatusDao;
import com.lawencon.ticketms.model.TicketStatus;
import com.lawencon.ticketms.repository.jpql.TicketStatusRepositoryJpql;

@Repository
@Profile("datajpql")
public class TicketStatusDaoImpl extends BaseDaoImpl implements TicketStatusDao{
	
	@Autowired
	private TicketStatusRepositoryJpql repository;
	
	@Override
	public TicketStatus insert(final TicketStatus data)  {
		return repository.save(data);
	}

	@Override
	public TicketStatus update(final TicketStatus data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<TicketStatus> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<TicketStatus> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public Optional<TicketStatus> getByCode(final String code) {
		final TicketStatus result = repository.getByCode(code).get();
		em.detach(result);
		return Optional.ofNullable(result);
	}

}
