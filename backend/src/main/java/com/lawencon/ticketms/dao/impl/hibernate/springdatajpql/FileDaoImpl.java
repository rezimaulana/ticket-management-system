package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.FileDao;
import com.lawencon.ticketms.model.File;
import com.lawencon.ticketms.repository.jpql.FileRepositoryJpql;

@Repository
@Profile("datajpql")
public class FileDaoImpl extends BaseDaoImpl implements FileDao{
	
	@Autowired
	private FileRepositoryJpql repository;
	
	@Override
	public File insert(final File data)  {
		return repository.save(data);
	}

	@Override
	public File update(final File data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<File> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<File> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}
}
