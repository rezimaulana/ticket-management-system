package com.lawencon.ticketms.repository.jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.File;

@Repository
public interface FileRepositoryJpql  extends JpaRepository<File, Long>{
	int removeById(Long id);
}
