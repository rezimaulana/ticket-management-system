package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketDao;
import com.lawencon.ticketms.model.Ticket;

@Repository
@Profile("hql")
public class TicketDaoImpl extends BaseDaoImpl implements TicketDao {
	
	@Override
	public Ticket insert(final Ticket data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Ticket update(final Ticket data)  {
		final Ticket updateOne = this.em.merge(data);
		this.em.flush();	
		return updateOne;
	}

	@Override
	public Optional<Ticket> getById(final Long id)  {
		final String sql = "SELECT t "
				+ "FROM Ticket t "
				+ "INNER JOIN FETCH t.ticketPriority tp "
				+ "INNER JOIN FETCH t.ticketStatus ts "
				+ "INNER JOIN FETCH t.productCustomer pc "
				+ "INNER JOIN FETCH pc.product p "
				+ "WHERE t.id = :id";
		final Ticket result = this.em.createQuery(sql, Ticket.class).setParameter("id", id).getSingleResult();
		final Optional<Ticket> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<Ticket> getAll()  {
		final String sql = " SELECT t "
				+ "	FROM Ticket t ";
		final List<Ticket> ticket = this.em.createQuery(sql, Ticket.class).getResultList();
		return ticket;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM Ticket WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public List<Ticket> getAllIdCust(final Long id)  {
		final String sql = "SELECT t "
				+ "FROM Ticket t "
				+ "INNER JOIN FETCH t.ticketPriority tp "
				+ "INNER JOIN FETCH t.ticketStatus ts "
				+ "INNER JOIN FETCH t.productCustomer pc "
				+ "INNER JOIN FETCH pc.product p "
				+ "INNER JOIN FETCH pc.user u "
				+ "WHERE u.id = :id";
		final List<Ticket> result = this.em.createQuery(sql, Ticket.class)
				.setParameter("id", id).getResultList();
		return result;
	}

	@Override
	public Ticket updateStatus(final Ticket data)  {
		final Ticket updateOne = this.em.merge(data);
		this.em.flush();	
		return updateOne;
	}

	@Override
	public List<Ticket> getAllIdPic(Long id)  {
		final String sql = "SELECT t "
				+ "FROM Ticket t "
				+ "INNER JOIN FETCH t.ticketPriority tp "
				+ "INNER JOIN FETCH t.ticketStatus ts "
				+ "INNER JOIN FETCH t.productCustomer pc "
				+ "INNER JOIN FETCH pc.product p "
				+ "INNER JOIN FETCH pc.user u "
				+ "INNER JOIN FETCH u.picId pic "
				+ "WHERE pic.id = :id";
		final List<Ticket> result = this.em.createQuery(sql, Ticket.class)
				.setParameter("id", id).getResultList();
		return result;
	}

}
