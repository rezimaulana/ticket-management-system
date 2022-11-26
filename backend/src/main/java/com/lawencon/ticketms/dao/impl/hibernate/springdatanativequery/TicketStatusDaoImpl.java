package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketStatusDao;
import com.lawencon.ticketms.model.TicketStatus;
import com.lawencon.ticketms.repository.nativequery.TicketStatusRepositoryNative;

@Repository
@Profile("datanative")
public class TicketStatusDaoImpl extends BaseDaoImpl implements TicketStatusDao{
	
	@Autowired
	private TicketStatusRepositoryNative repository;
	
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
		final TicketStatus getOne = this.em.find(TicketStatus.class, id);
		em.detach(getOne);
		final Optional<TicketStatus> ticketStatusOptional = Optional.ofNullable(getOne);
		return ticketStatusOptional;
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
		final TicketStatus ticketStatus = repository.getByCode(code);
		final Optional<TicketStatus> optional = Optional.ofNullable(ticketStatus);
		return optional;
	}

}
