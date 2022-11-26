package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.ProductDao;
import com.lawencon.ticketms.model.Product;
import com.lawencon.ticketms.repository.nativequery.ProductRepositoryNative;

@Repository
@Profile("datanative")
public class ProductDaoImpl extends BaseDaoImpl implements ProductDao{
	
	@Autowired
	private ProductRepositoryNative repository;
	
	@Override
	public Product insert(final Product data){
		return repository.save(data);
	}

	@Override
	public Product update(final Product data){
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<Product> getById(final Long id){
		final Product product = this.em.find(Product.class, id);
		em.detach(product);
		final Optional<Product> productOptional = Optional.ofNullable(product);
		return productOptional;
	}

	@Override
	public List<Product> getAll(){
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id){
		final int result = repository.removeById(id);
		return result > 0;
	}

}