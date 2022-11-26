package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.ProductCustomerDao;
import com.lawencon.ticketms.model.ProductCustomer;
import com.lawencon.ticketms.repository.jpql.ProductCustomerRepositoryJpql;

@Repository
@Profile("datajpql")
public class ProductCustomerDaoImpl extends BaseDaoImpl implements ProductCustomerDao{

	@Autowired
	private ProductCustomerRepositoryJpql repository;
	
	@Override
	public ProductCustomer insert(final ProductCustomer data)  {
		return repository.save(data);
	}

	@Override
	public ProductCustomer update(final ProductCustomer data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<ProductCustomer> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<ProductCustomer> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public List<ProductCustomer> getAllIdCust(final Long id)  {
		return repository.getAllIdCust(id);
	}

}
