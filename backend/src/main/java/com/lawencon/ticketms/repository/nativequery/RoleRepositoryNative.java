package com.lawencon.ticketms.repository.nativequery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.Role;

@Repository
public interface RoleRepositoryNative extends JpaRepository<Role, Long>{
	int removeById(Long id);
}
