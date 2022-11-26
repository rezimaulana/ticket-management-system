package com.lawencon.ticketms.repository.jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.Product;

@Repository
public interface ProductRepositoryJpql extends JpaRepository<Product, Long>{
	int removeById(Long id);
}
