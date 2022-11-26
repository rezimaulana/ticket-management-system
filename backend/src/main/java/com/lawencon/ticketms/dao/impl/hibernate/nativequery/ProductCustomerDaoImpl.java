package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.ProductCustomerDao;
import com.lawencon.ticketms.model.ProductCustomer;

@Repository
@Profile("native")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCustomer> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM products_cust pc ";
		final List<ProductCustomer> productCustomer = this.em.createNativeQuery(sql, ProductCustomer.class).getResultList();
		return productCustomer;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM products_cust WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCustomer> getAllIdCust(final Long id)  {
		final String sql = "SELECT * "
				+ "FROM products_cust pc "
				+ "INNER JOIN products p ON p.id = pc.product_id "
				+ "INNER JOIN users c ON c.id = pc.customer_id "
				+ "WHERE c.id = :id ";
		final List<ProductCustomer> result = this.em.createNativeQuery(sql, ProductCustomer.class)
				.setParameter("id", id).getResultList();
		return result;
	}

}

//@Override
//public List<ProductCustomer> getAllIdCust(final Long id)  {
//	final String sql = "SELECT pc.id AS pcId, pc.ver AS pcVer, "
//			+ "p.id AS pId, p.product_code AS pCode, p.product_name AS pName, "
//			+ "c.id AS cId, c.email AS cEmail, c.fullname AS cName "
//			+ "FROM products_cust pc "
//			+ "INNER JOIN products p ON p.id = pc.product_id "
//			+ "INNER JOIN users c ON c.id = pc.customer_id "
//			+ "WHERE c.id = :id ";
//	final List<?> result = this.em.createNativeQuery(sql)
//			.setParameter("id", id).getResultList();
//	final List<ProductCustomer> productCustomer =  new ArrayList<>();
//	if(result != null && result.size() > 0) {
//		result.forEach(userObj -> {
//			Object[] objArr = (Object[]) userObj;
//			final ProductCustomer productCust = new ProductCustomer();
//			productCust.setId(Long.valueOf(objArr[0].toString()));
//			productCust.setVer(Integer.valueOf(objArr[1].toString()));
//			final Product product = new Product();
//			product.setId(Long.valueOf(objArr[2].toString()));
//			product.setProductCode(objArr[3].toString());
//			product.setProductName(objArr[4].toString());
//			productCust.setProduct(product);
//			final User cust = new User();
//			cust.setId(Long.valueOf(objArr[5].toString()));
//			cust.setEmail(objArr[6].toString());
//			cust.setFullname(objArr[7].toString());
//			productCust.setUser(cust);
//			productCustomer.add(productCust);
//		});
//	}
//	return productCustomer;
//}