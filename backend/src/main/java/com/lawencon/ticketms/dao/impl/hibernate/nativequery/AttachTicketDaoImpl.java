package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.AttachTicketDao;
import com.lawencon.ticketms.model.AttachmentTicket;

@Repository
@Profile("native")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<AttachmentTicket> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM attachments_ticket ac ";
		final List<AttachmentTicket> attachmentTicket = this.em.createNativeQuery(sql, AttachmentTicket.class).getResultList();
		return attachmentTicket;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM attachments_ticket WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttachmentTicket> getAllIdTicket(final long id) {
		final String sql = "SELECT * "
				+ "FROM attachments_ticket ac "
				+ "INNER JOIN files f ON f.id = ac.file_id "
				+ "WHERE ac.ticket_id = :id";
		final List<AttachmentTicket> result = this.em.createNativeQuery(sql, AttachmentTicket.class).setParameter("id", id).getResultList();
		return result;
	}

}


