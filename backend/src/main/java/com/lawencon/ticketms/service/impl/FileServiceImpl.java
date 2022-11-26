package com.lawencon.ticketms.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.dao.FileDao;
import com.lawencon.ticketms.model.File;
import com.lawencon.ticketms.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	@Autowired
	private FileDao fileDao;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public File insert(final File data) throws SQLException {
		File insertOne = null;
		data.setCreatedAt(java.time.LocalDateTime.now());
		data.setVer(0);
		data.setIsActive(true);
		insertOne = fileDao.insert(data);
		return insertOne;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public File update(final File data) throws SQLException {
		File updateOne = null;
		updateOne = fileDao.update(data);
		return updateOne;
	}

	@Override
	public Optional<File> getById(final Long id) throws SQLException {
		return fileDao.getById(id);
	}

	@Override
	public List<File> getAll() throws SQLException {
		return fileDao.getAll();
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public boolean deleteById(final Long id) throws SQLException {
		boolean deleteOne = false;
		deleteOne = fileDao.deleteById(id);
		return deleteOne;
	}

}
