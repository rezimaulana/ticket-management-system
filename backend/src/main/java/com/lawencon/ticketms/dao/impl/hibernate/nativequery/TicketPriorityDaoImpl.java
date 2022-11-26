package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketPriorityDao;
import com.lawencon.ticketms.model.TicketPriority;

@Repository
@Profile("native")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketPriority> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM tickets_priority tp ";
		final List<TicketPriority> ticketPriority = this.em.createNativeQuery(sql, TicketPriority.class).getResultList();
		return ticketPriority;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM tickets_priority WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public Optional<TicketPriority> getByCode(final String code) {
		final String sql = " SELECT id, priority_code, priority, ver, created_at, created_by, is_active  "
				+ "FROM tickets_priority where lower(priority_code) = lower(:code) ";
		TicketPriority tp = null;
		try {			
			final Object userObj = this.em.createNativeQuery(sql)
					.setParameter("code", code)
					.getSingleResult();
			if(userObj !=null) {
				Object[] objArr = (Object[]) userObj;
				tp = new TicketPriority();
				tp.setId(Long.valueOf(objArr[0].toString()));
				tp.setPriorityCode(objArr[1].toString());
				tp.setPriority(objArr[2].toString());
				tp.setVer(Integer.valueOf(objArr[3].toString()));
				tp.setCreatedAt(Timestamp.valueOf(objArr[4].toString()).toLocalDateTime());
				tp.setCreatedBy(Long.valueOf(objArr[5].toString()));
				tp.setIsActive(Boolean.valueOf(objArr[6].toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		final Optional<TicketPriority> optional = Optional.ofNullable(tp);
		return optional;
	}
}
