package com.lawencon.ticketms.repository.jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.Role;

@Repository
public interface RoleRepositoryJpql extends JpaRepository<Role, Long>{
	int removeById(Long id);
}
