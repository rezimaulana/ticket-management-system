package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.FileDao;
import com.lawencon.ticketms.model.File;

@Repository
@Profile("native")
public class FileDaoImpl extends BaseDaoImpl implements FileDao{
	
	@Override
	public File insert(final File data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public File update(final File data)  {
		final File updateOne = this.em.merge(data);
		this.em.flush();
		return updateOne;
	}

	@Override
	public Optional<File> getById(final Long id)  {
		final File file = this.em.find(File.class, id);
		em.detach(file);
		final Optional<File> fileOptional = Optional.ofNullable(file);
		return fileOptional;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<File> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM files f ";
		final List<File> files = this.em.createNativeQuery(sql, File.class).getResultList();
		return files;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM files WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}
}
