package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketPriorityDao;
import com.lawencon.ticketms.model.TicketPriority;
import com.lawencon.ticketms.repository.nativequery.TicketPriorityRepositoryNative;

@Repository
@Profile("datanative")
public class TicketPriorityDaoImpl extends BaseDaoImpl implements TicketPriorityDao{
	
	@Autowired
	private TicketPriorityRepositoryNative repository;
	
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
		final TicketPriority getOne = this.em.find(TicketPriority.class, id);
		em.detach(getOne);
		final Optional<TicketPriority > ticketPriorityOptional = Optional.ofNullable(getOne);
		return ticketPriorityOptional;
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
		final TicketPriority ticketPriority = repository.getByCode(code);
		final Optional<TicketPriority> optional = Optional.ofNullable(ticketPriority);
		return optional;
	}
}
