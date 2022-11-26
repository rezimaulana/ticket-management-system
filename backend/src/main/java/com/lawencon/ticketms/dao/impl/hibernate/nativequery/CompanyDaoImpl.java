package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.CompanyDao;
import com.lawencon.ticketms.model.Company;

@Repository
@Profile("native")
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {
	
	@Override
	public Company insert(final Company data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Company update(final Company data)  {
		final Company updateOne = this.em.merge(data);
		this.em.flush();
		return updateOne;
	}

	@Override
	public Optional<Company> getById(final Long id)  {
		final Company company = this.em.find(Company.class, id);
		em.detach(company);
		final Optional<Company> companyOptional = Optional.ofNullable(company);
		return companyOptional;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM companies u ";
		final List<Company> company = this.em.createNativeQuery(sql, Company.class).getResultList();
		return company;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM companies WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

}
