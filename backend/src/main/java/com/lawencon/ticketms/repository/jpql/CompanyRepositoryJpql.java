package com.lawencon.ticketms.repository.jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.Company;

@Repository
public interface CompanyRepositoryJpql extends JpaRepository<Company, Long>{
	int removeById(Long id);
}
