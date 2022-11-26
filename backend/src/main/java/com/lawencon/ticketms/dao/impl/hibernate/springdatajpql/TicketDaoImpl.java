package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketDao;
import com.lawencon.ticketms.model.Ticket;
import com.lawencon.ticketms.repository.jpql.TicketRepositoryJpql;

@Repository
@Profile("datajpql")
public class TicketDaoImpl extends BaseDaoImpl implements TicketDao {
	
	@Autowired
	private TicketRepositoryJpql repository;
	
	@Override
	public Ticket insert(final Ticket data)  {
		return repository.save(data);
	}

	@Override
	public Ticket update(final Ticket data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<Ticket> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<Ticket> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public List<Ticket> getAllIdCust(final Long id)  {
		return repository.findAll();
	}

	@Override
	public Ticket updateStatus(final Ticket data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public List<Ticket> getAllIdPic(Long id)  {
		return repository.findAll();
	}

}
