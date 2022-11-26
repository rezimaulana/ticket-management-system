package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.dao.RoleDao;
import com.lawencon.ticketms.dto.role.RoleDataDto;
import com.lawencon.ticketms.dto.role.RoleListResDto;
import com.lawencon.ticketms.dto.role.RoleResDto;
import com.lawencon.ticketms.model.Role;
import com.lawencon.ticketms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public RoleResDto getById(final Long id) {
		final Optional<Role> optional = roleDao.getById(id);
		final Role role = optional.get();
		
		final RoleDataDto roleDataDto = new RoleDataDto();
		roleDataDto.setId(role.getId());
		roleDataDto.setRoleCode(role.getRoleCode());
		roleDataDto.setRoleName(role.getRoleName());
		roleDataDto.setVer(role.getVer());
		
		final RoleResDto roleResDto = new RoleResDto();
		roleResDto.setData(roleDataDto);
		
		return roleResDto;
	}

	@Override
	public RoleListResDto getAll() {
		final List<Role> roles = roleDao.getAll();
		final List<RoleDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<roles.size(); i++) {
			final Role role = roles.get(i);
			final RoleDataDto dto = new RoleDataDto();
			dto.setId(role.getId());
			dto.setRoleCode(role.getRoleCode());
			dto.setRoleName(role.getRoleName());
			dto.setVer(role.getVer());
			dataDto.add(dto);
		}
		final RoleListResDto roleListResDto = new RoleListResDto();
		roleListResDto.setData(dataDto);
		return roleListResDto;
	}

}
