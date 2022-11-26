package com.lawencon.ticketms.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {
	T insert(T data);

	T update(T data);

	Optional<T> getById(Long id);

	List<T> getAll();

	boolean deleteById(Long id);
}
