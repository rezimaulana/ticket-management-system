package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.role.RoleListResDto;
import com.lawencon.ticketms.dto.role.RoleResDto;

public interface RoleService {
	RoleResDto getById(Long id);
	RoleListResDto getAll();
}
