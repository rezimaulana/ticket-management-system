package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.CompanyDao;
import com.lawencon.ticketms.model.Company;
import com.lawencon.ticketms.repository.nativequery.CompanyRepositoryNative;

@Repository
@Profile("datanative")
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {
	
	@Autowired
	private CompanyRepositoryNative repository;
	
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
		final Company company = this.em.find(Company.class, id);
		em.detach(company);
		final Optional<Company> companyOptional = Optional.ofNullable(company);
		return companyOptional;
	}

	@Override
	public List<Company> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

}
