package com.lawencon.ticketms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.service.PrincipalService;

@Service
public class PrincipalServiceImpl implements PrincipalService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getPrincipal() {
		long id = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		Optional<User> optional = userDao.getById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		throw new RuntimeException("Invalid Login");
	}

	
	
}

