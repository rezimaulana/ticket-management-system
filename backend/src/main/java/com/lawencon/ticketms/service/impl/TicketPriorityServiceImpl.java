package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.dao.TicketPriorityDao;
import com.lawencon.ticketms.dto.ticketpriority.TicketPriorityDataDto;
import com.lawencon.ticketms.dto.ticketpriority.TicketPriorityListResDto;
import com.lawencon.ticketms.dto.ticketpriority.TicketPriorityResDto;
import com.lawencon.ticketms.model.TicketPriority;
import com.lawencon.ticketms.service.TicketPriorityService;

@Service
public class TicketPriorityServiceImpl implements TicketPriorityService{
	
	@Autowired
	private TicketPriorityDao ticketPriorityDao;

	@Override
	public TicketPriorityResDto getById(final Long id) {
		final Optional<TicketPriority> optional = ticketPriorityDao.getById(id);
		final TicketPriority ticketPriority = optional.get();
		
		final TicketPriorityDataDto ticketPriorityDataDto = new TicketPriorityDataDto();
		ticketPriorityDataDto.setId(ticketPriority.getId());
		ticketPriorityDataDto.setPriorityCode(ticketPriority.getPriorityCode());;
		ticketPriorityDataDto.setPriority(ticketPriority.getPriority());
		ticketPriorityDataDto.setVer(ticketPriority.getVer());
		
		final TicketPriorityResDto ticketPriorityResDto = new TicketPriorityResDto();
		ticketPriorityResDto.setData(ticketPriorityDataDto);
		
		return ticketPriorityResDto;
	}

	@Override
	public TicketPriorityListResDto getAll() {
		final List<TicketPriority> ticketPrioritys = ticketPriorityDao.getAll();
		final List<TicketPriorityDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<ticketPrioritys.size(); i++) {
			final TicketPriority ticketPriority = ticketPrioritys.get(i);
			final TicketPriorityDataDto dto = new TicketPriorityDataDto();
			dto.setId(ticketPriority.getId());
			dto.setPriorityCode(ticketPriority.getPriorityCode());
			dto.setPriority(ticketPriority.getPriority());
			dto.setVer(ticketPriority.getVer());
			dataDto.add(dto);
		}
		final TicketPriorityListResDto ticketPriorityListResDto = new TicketPriorityListResDto();
		ticketPriorityListResDto.setData(dataDto);
		return ticketPriorityListResDto;
	}

	@Override
	public TicketPriorityResDto getByCode(String code) {
		final Optional<TicketPriority> optional = ticketPriorityDao.getByCode(code);
		final TicketPriority ticketPriority = optional.get();
		
		final TicketPriorityDataDto ticketPriorityDataDto = new TicketPriorityDataDto();
		ticketPriorityDataDto.setId(ticketPriority.getId());
		ticketPriorityDataDto.setPriorityCode(ticketPriority.getPriorityCode());;
		ticketPriorityDataDto.setPriority(ticketPriority.getPriority());
		ticketPriorityDataDto.setVer(ticketPriority.getVer());
		
		final TicketPriorityResDto ticketPriorityResDto = new TicketPriorityResDto();
		ticketPriorityResDto.setData(ticketPriorityDataDto);
		
		return ticketPriorityResDto;
	}
	
}
