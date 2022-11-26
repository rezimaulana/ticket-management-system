package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.CompanyDao;
import com.lawencon.ticketms.model.Company;
import com.lawencon.ticketms.repository.jpql.CompanyRepositoryJpql;

@Repository
@Profile("datajpql")
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {
	
	@Autowired
	private CompanyRepositoryJpql repository;
	
	@Override
	public Company insert(final Company data)  {
		return repository.save(data);
	}

	@Override
	public Company update(final Company data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<Company> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public List<Company> getAll()  {
		return repository.findAll();
	}
	
}
