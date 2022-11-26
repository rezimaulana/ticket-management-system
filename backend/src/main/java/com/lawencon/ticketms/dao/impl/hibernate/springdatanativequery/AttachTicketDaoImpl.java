package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.AttachTicketDao;
import com.lawencon.ticketms.model.AttachmentTicket;
import com.lawencon.ticketms.repository.nativequery.AttachTicketRepositoryNative;

@Repository
@Profile("datanative")
public class AttachTicketDaoImpl extends BaseDaoImpl implements AttachTicketDao {
	
	@Autowired
	private AttachTicketRepositoryNative repository;
	
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
		final AttachmentTicket attachmentTicket = this.em.find(AttachmentTicket.class, id);
		em.detach(attachmentTicket);
		final Optional<AttachmentTicket> attachmentTicketOptional = Optional.ofNullable(attachmentTicket);
		return attachmentTicketOptional;
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
	public List<AttachmentTicket> getAllIdTicket(final long id) {
		return repository.getAllIdTicket(id);
	}
}


