package com.lawencon.ticketms.dao;

import java.util.List;
import java.util.Optional;

import com.lawencon.ticketms.model.User;

public interface UserDao extends BaseDao<User>{
	Optional<User> getByEmail(String email);
	List<User> getAllIdCust();
	List<User> getAllIdPic();
	List<User> getAllIdPicIdCust(long id);
	}
