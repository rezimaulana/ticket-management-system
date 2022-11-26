package com.lawencon.ticketms.repository.nativequery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.File;

@Repository
public interface FileRepositoryNative extends JpaRepository<File, Long>{
	int removeById(Long id);
}
