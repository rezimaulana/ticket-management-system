package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.RoleDao;
import com.lawencon.ticketms.model.Role;

@Repository
@Profile("hql")
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao{
	
	@Override
	public Role insert(final Role data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Role update(final Role data)  {
		final Role updateOne = this.em.merge(data);
		this.em.flush();
		return updateOne;
	}

	@Override
	public Optional<Role> getById(final Long id)  {
		final Role role = this.em.find(Role.class, id);
		em.detach(role);
		final Optional<Role> roleOptional = Optional.ofNullable(role);
		return roleOptional;
	}

	@Override
	public List<Role> getAll()  {
		final String sql = " SELECT r "
				+ "	FROM Role r ";
		final List<Role> role = this.em.createQuery(sql, Role.class).getResultList();
		return role;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM Role WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();

		return result > 0;
	}

}
