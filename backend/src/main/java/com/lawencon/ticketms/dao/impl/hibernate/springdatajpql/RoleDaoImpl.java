package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.RoleDao;
import com.lawencon.ticketms.model.Role;
import com.lawencon.ticketms.repository.jpql.RoleRepositoryJpql;

@Repository
@Profile("datajpql")
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao{
	
	@Autowired
	private RoleRepositoryJpql repository;
	
	@Override
	public Role insert(final Role data)  {
		return repository.save(data);
	}

	@Override
	public Role update(final Role data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<Role> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<Role> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

}
