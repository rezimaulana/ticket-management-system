package com.lawencon.ticketms.repository.nativequery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.ProductCustomer;

@Repository
public interface ProductCustomerRepositoryNative extends JpaRepository<ProductCustomer, Long>{
	int removeById(Long id);
	@Query(value="SELECT pc.id AS pcId, pc.ver AS pcVer, "
				+ "p.id AS pId, p.product_code AS pCode, p.product_name AS pName, "
				+ "c.id AS cId, c.email AS cEmail, c.fullname AS cName "
				+ "FROM products_cust pc "
				+ "INNER JOIN products p ON p.id = pc.product_id "
				+ "INNER JOIN users c ON c.id = pc.customer_id "
				+ "WHERE c.id = :id ",nativeQuery=true)
	List <Object[]>getAllIdCust(@Param("id") final Long id);
}
