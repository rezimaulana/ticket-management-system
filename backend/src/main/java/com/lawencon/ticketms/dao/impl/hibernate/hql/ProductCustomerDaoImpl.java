package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.ProductCustomerDao;
import com.lawencon.ticketms.model.ProductCustomer;

@Repository
@Profile("hql")
public class ProductCustomerDaoImpl extends BaseDaoImpl implements ProductCustomerDao{

	@Override
	public ProductCustomer insert(final ProductCustomer data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public ProductCustomer update(final ProductCustomer data)  {
		final ProductCustomer updateOne = this.em.merge(data);
		this.em.flush();
		return updateOne;
	}

	@Override
	public Optional<ProductCustomer> getById(final Long id)  {
		final ProductCustomer productCustomer = this.em.find(ProductCustomer.class, id);
		em.detach(productCustomer);
		final Optional<ProductCustomer> productCustomerOptional = Optional.ofNullable(productCustomer);
		return productCustomerOptional;
	}

	@Override
	public List<ProductCustomer> getAll()  {
		final String sql = " SELECT pc "
				+ "	FROM ProductCustomer pc ";
		final List<ProductCustomer> productCustomer = this.em.createQuery(sql, ProductCustomer.class).getResultList();
		return productCustomer;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM ProductCustomer WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public List<ProductCustomer> getAllIdCust(final Long id)  {
		final String sql = "SELECT pc "
				+ "FROM ProductCustomer pc "
				+ "INNER JOIN FETCH pc.product p "
				+ "INNER JOIN FETCH pc.user c "
				+ "WHERE c.id = :id ";
		final List<ProductCustomer> result = this.em.createQuery(sql, ProductCustomer.class)
				.setParameter("id", id).getResultList();
		return result;
	}

}
