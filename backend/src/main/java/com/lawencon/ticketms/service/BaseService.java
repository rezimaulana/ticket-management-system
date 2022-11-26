package com.lawencon.ticketms.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
	T insert(T data) throws SQLException;

	T update(T data) throws SQLException;

	Optional<T> getById(Long id) throws SQLException;

	List<T> getAll() throws SQLException;

	boolean deleteById(Long id) throws SQLException;
}
