package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketPriorityDao;
import com.lawencon.ticketms.model.TicketPriority;

@Repository
@Profile("hql")
public class TicketPriorityDaoImpl extends BaseDaoImpl implements TicketPriorityDao{
	
	@Override
	public TicketPriority insert(final TicketPriority data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public TicketPriority update(final TicketPriority data)  {
		final TicketPriority updateOne = this.em.merge(data);
		this.em.flush();
		return updateOne;
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
		final String sql = " SELECT tp "
				+ "	FROM TicketPriority tp ";
		final List<TicketPriority> ticketPriority = this.em.createQuery(sql, TicketPriority.class).getResultList();
		return ticketPriority;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM TicketPriority WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public Optional<TicketPriority> getByCode(final String code) {
		final String sql = " SELECT tp "
				+ "FROM TicketPriority tp "
				+ "where lower(tp.priorityCode) = lower(:code) ";
		final TicketPriority result = this.em.createQuery(sql, TicketPriority.class).setParameter("code", code).getSingleResult();
		final Optional<TicketPriority> optional = Optional.ofNullable(result);
		return optional;
	}
}
