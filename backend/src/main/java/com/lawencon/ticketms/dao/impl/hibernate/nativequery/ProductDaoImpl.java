package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.ProductDao;
import com.lawencon.ticketms.model.Product;

@Repository
@Profile("native")
public class ProductDaoImpl extends BaseDaoImpl implements ProductDao{
	
	@Override
	public Product insert(final Product data){
		this.em.persist(data);
		return data;
	}

	@Override
	public Product update(final Product data){
		final Product updateOne = this.em.merge(data);
		this.em.flush();	
		return updateOne;
	}

	@Override
	public Optional<Product> getById(final Long id){
		final Product product = this.em.find(Product.class, id);
		em.detach(product);
		final Optional<Product> productOptional = Optional.ofNullable(product);
		return productOptional;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAll(){
		final String sql = " SELECT * "
				+ "	FROM products u ";
		final List<Product> product = this.em.createNativeQuery(sql, Product.class).getResultList();
		return product;
	}

	@Override
	public boolean deleteById(final Long id){
		final String sql = " DELETE FROM products WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

}