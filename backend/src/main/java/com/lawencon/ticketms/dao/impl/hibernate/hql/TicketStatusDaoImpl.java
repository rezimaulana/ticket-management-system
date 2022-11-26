package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketStatusDao;
import com.lawencon.ticketms.model.TicketStatus;

@Repository
@Profile("hql")
public class TicketStatusDaoImpl extends BaseDaoImpl implements TicketStatusDao{
	
	@Override
	public TicketStatus insert(final TicketStatus data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public TicketStatus update(final TicketStatus data)  {
		final TicketStatus updateOne = this.em.merge(data);
		this.em.flush();
		return updateOne;
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
		final String sql = " SELECT ts "
				+ "	FROM TicketStatus ts ";
		final List<TicketStatus> findAll = this.em.createQuery(sql, TicketStatus.class).getResultList();
		return findAll;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM TicketStatus WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public Optional<TicketStatus> getByCode(final String code) {
		final String sql = " SELECT ts "
				+ "FROM TicketStatus ts "
				+ "where lower(statusCode) = lower(:code) ";
		final TicketStatus result = this.em.createQuery(sql, TicketStatus.class).setParameter("code", code).getSingleResult();
		final Optional<TicketStatus> optional = Optional.ofNullable(result);
		return optional;
	}

}
