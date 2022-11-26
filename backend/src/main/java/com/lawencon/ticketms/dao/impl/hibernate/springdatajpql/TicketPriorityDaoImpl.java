package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketPriorityDao;
import com.lawencon.ticketms.model.TicketPriority;
import com.lawencon.ticketms.repository.jpql.TicketPriorityRepositoryJpql;

@Repository
@Profile("datajpql")
public class TicketPriorityDaoImpl extends BaseDaoImpl implements TicketPriorityDao{
	
	@Autowired
	private TicketPriorityRepositoryJpql repository;
	
	@Override
	public TicketPriority insert(final TicketPriority data)  {
		return repository.save(data);
	}

	@Override
	public TicketPriority update(final TicketPriority data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<TicketPriority> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<TicketPriority> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public Optional<TicketPriority> getByCode(final String code) {
		final TicketPriority result = repository.getByCode(code).get();
		em.detach(result);
		return Optional.ofNullable(result);
	}
}
