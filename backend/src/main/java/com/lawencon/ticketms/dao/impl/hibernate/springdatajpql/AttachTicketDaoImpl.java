package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.AttachTicketDao;
import com.lawencon.ticketms.model.AttachmentTicket;
import com.lawencon.ticketms.repository.jpql.AttachTicketRepositoryJpql;

@Repository
@Profile("datajpql")
public class AttachTicketDaoImpl extends BaseDaoImpl implements AttachTicketDao {

	@Autowired
	AttachTicketRepositoryJpql repository;
	
	@Override
	public AttachmentTicket insert(final AttachmentTicket data)  {
		return repository.save(data);
	}

	@Override
	public AttachmentTicket update(final AttachmentTicket data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<AttachmentTicket> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<AttachmentTicket> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public List<AttachmentTicket> getAllIdTicket(long id) {
		return repository.getAllIdTicket(id);
	}
}


