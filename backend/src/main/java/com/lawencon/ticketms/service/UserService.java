package com.lawencon.ticketms.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lawencon.ticketms.dto.user.UserDeleteResDto;
import com.lawencon.ticketms.dto.user.UserInsertReqDto;
import com.lawencon.ticketms.dto.user.UserInsertResDto;
import com.lawencon.ticketms.dto.user.UserListResDto;
import com.lawencon.ticketms.dto.user.UserResDto;
import com.lawencon.ticketms.dto.user.UserUpdateReqDto;
import com.lawencon.ticketms.dto.user.UserUpdateResDto;
import com.lawencon.ticketms.model.User;

public interface UserService extends UserDetailsService{	
	UserInsertResDto insert(UserInsertReqDto data);
	UserUpdateResDto update(UserUpdateReqDto data);
	UserResDto getById(Long id);
	UserListResDto getAll();
	UserDeleteResDto deleteById(Long id);
	Optional<User> getByEmail(String email);
	UserListResDto getAllIdCust();	
	UserListResDto getAllIdPic();
	UserListResDto getAllIdPicIdCust(long id);
		
}
