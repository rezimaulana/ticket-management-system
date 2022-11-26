package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.ProductCustomerDao;
import com.lawencon.ticketms.model.Product;
import com.lawencon.ticketms.model.ProductCustomer;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.repository.nativequery.ProductCustomerRepositoryNative;

@Repository
@Profile("datanative")
public class ProductCustomerDaoImpl extends BaseDaoImpl implements ProductCustomerDao{
	
	@Autowired
	private ProductCustomerRepositoryNative repository;
	
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
		final ProductCustomer productCustomer = this.em.find(ProductCustomer.class, id);
		em.detach(productCustomer);
		final Optional<ProductCustomer> productCustomerOptional = Optional.ofNullable(productCustomer);
		return productCustomerOptional;
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
		final List<?> result = repository.getAllIdCust(id);
		final List<ProductCustomer> productCustomer =  new ArrayList<>();
		if(result != null && result.size() > 0) {
			result.forEach(userObj -> {
				Object[] objArr = (Object[]) userObj;
				final ProductCustomer productCust = new ProductCustomer();
				productCust.setId(Long.valueOf(objArr[0].toString()));
				productCust.setVer(Integer.valueOf(objArr[1].toString()));
				final Product product = new Product();
				product.setId(Long.valueOf(objArr[2].toString()));
				product.setProductCode(objArr[3].toString());
				product.setProductName(objArr[4].toString());
				productCust.setProduct(product);
	            final User cust = new User();
	            cust.setId(Long.valueOf(objArr[5].toString()));
	            cust.setEmail(objArr[6].toString());
	            cust.setFullname(objArr[7].toString());
	            productCust.setUser(cust);
	            productCustomer.add(productCust);
			});
		}
		return productCustomer;
	}

}
