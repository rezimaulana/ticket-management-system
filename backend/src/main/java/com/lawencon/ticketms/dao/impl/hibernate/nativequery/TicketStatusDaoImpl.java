package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketStatusDao;
import com.lawencon.ticketms.model.TicketStatus;

@Repository
@Profile("native")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketStatus> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM tickets_status ts ";
		final List<TicketStatus> findAll = this.em.createNativeQuery(sql, TicketStatus.class).getResultList();
		return findAll;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM tickets_status WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public Optional<TicketStatus> getByCode(final String code) {
		final String sql = " SELECT id, status_code, status, ver, created_at, created_by, is_active "
				+ "FROM tickets_status where lower(status_code) = lower(:code) ";
		TicketStatus tp = null;
		try {			
			final Object userObj = this.em.createNativeQuery(sql)
					.setParameter("code", code)
					.getSingleResult();
			if(userObj !=null) {
				Object[] objArr = (Object[]) userObj;
				tp = new TicketStatus();
				tp.setId(Long.valueOf(objArr[0].toString()));
				tp.setStatusCode(objArr[1].toString());
				tp.setStatus(objArr[2].toString());
				tp.setVer(Integer.valueOf(objArr[3].toString()));
				tp.setCreatedAt(Timestamp.valueOf(objArr[4].toString()).toLocalDateTime());
				tp.setCreatedBy(Long.valueOf(objArr[5].toString()));
				tp.setIsActive(Boolean.valueOf(objArr[6].toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.em.detach(tp);
		final Optional<TicketStatus> optional = Optional.ofNullable(tp);
		return optional;
	}

}
