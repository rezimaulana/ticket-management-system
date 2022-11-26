package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.AttachTicketDao;
import com.lawencon.ticketms.model.AttachmentTicket;

@Repository
@Profile("hql")
public class AttachTicketDaoImpl extends BaseDaoImpl implements AttachTicketDao {

	@Override
	public AttachmentTicket insert(final AttachmentTicket data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public AttachmentTicket update(final AttachmentTicket data)  {
		final AttachmentTicket updateOne = this.em.merge(data);
		this.em.flush();	
		return updateOne;
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
		final String sql = " SELECT ac "
				+ "	FROM AttachmentTicket ac ";
		final List<AttachmentTicket> attachmentTicket = this.em.createQuery(sql, AttachmentTicket.class).getResultList();
		return attachmentTicket;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM AttachmentTicket WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public List<AttachmentTicket> getAllIdTicket(final long id) {
		final String sql = " SELECT ac "
				+ "	FROM AttachmentTicket ac "
				+ "INNER JOIN FETCH ac.file f "
				+ "INNER JOIN FETCH ac.ticket t "
				+ "WHERE t.id = :id ";
		final List<AttachmentTicket> result = this.em.createQuery(sql, AttachmentTicket.class)
				.setParameter("id", id).getResultList();
		return result;
	}
	
}


