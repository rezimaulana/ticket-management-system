package com.lawencon.ticketms.repository.jpql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.ProductCustomer;

@Repository
public interface ProductCustomerRepositoryJpql extends JpaRepository<ProductCustomer, Long>{
	int removeById(Long id);
	@Query( "SELECT pc "
			+ "FROM ProductCustomer pc "
			+ "INNER JOIN FETCH pc.product p "
			+ "INNER JOIN FETCH pc.user c "
			+ "WHERE c.id = :id ")
	List<ProductCustomer> getAllIdCust(@Param("id") Long id);
}
