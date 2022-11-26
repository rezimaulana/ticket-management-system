package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.dao.TicketStatusDao;
import com.lawencon.ticketms.dto.ticketstatus.TicketStatusDataDto;
import com.lawencon.ticketms.dto.ticketstatus.TicketStatusListResDto;
import com.lawencon.ticketms.dto.ticketstatus.TicketStatusResDto;
import com.lawencon.ticketms.model.TicketStatus;
import com.lawencon.ticketms.service.TicketStatusService;

@Service
public class TicketStatusServiceImpl implements TicketStatusService{
	
	@Autowired
	private TicketStatusDao ticketStatusDao;
	
	@Override
	public TicketStatusResDto getById(final Long id) {
		final Optional<TicketStatus> optional = ticketStatusDao.getById(id);
		final TicketStatus ticketStatus = optional.get();
		
		final TicketStatusDataDto ticketStatusDataDto = new TicketStatusDataDto();
		ticketStatusDataDto.setId(ticketStatus.getId());
		ticketStatusDataDto.setStatusCode(ticketStatus.getStatusCode());;
		ticketStatusDataDto.setStatus(ticketStatus.getStatus());
		ticketStatusDataDto.setVer(ticketStatus.getVer());
		
		final TicketStatusResDto ticketStatusResDto = new TicketStatusResDto();
		ticketStatusResDto.setData(ticketStatusDataDto);
		
		return ticketStatusResDto;
	}

	@Override
	public TicketStatusListResDto getAll() {
		final List<TicketStatus> ticketStatuss = ticketStatusDao.getAll();
		final List<TicketStatusDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<ticketStatuss.size(); i++) {
			final TicketStatus ticketStatus = ticketStatuss.get(i);
			final TicketStatusDataDto dto = new TicketStatusDataDto();
			dto.setId(ticketStatus.getId());
			dto.setStatusCode(ticketStatus.getStatusCode());
			dto.setStatus(ticketStatus.getStatus());
			dto.setVer(ticketStatus.getVer());
			dataDto.add(dto);
		}
		final TicketStatusListResDto ticketStatusListResDto = new TicketStatusListResDto();
		ticketStatusListResDto.setData(dataDto);
		return ticketStatusListResDto;
	}

	@Override
	public TicketStatusResDto getByCode(String code) {
		final Optional<TicketStatus> optional = ticketStatusDao.getByCode(code);
		final TicketStatus ticketStatus = optional.get();
		
		final TicketStatusDataDto ticketStatusDataDto = new TicketStatusDataDto();
		ticketStatusDataDto.setId(ticketStatus.getId());
		ticketStatusDataDto.setStatusCode(ticketStatus.getStatusCode());;
		ticketStatusDataDto.setStatus(ticketStatus.getStatus());
		ticketStatusDataDto.setVer(ticketStatus.getVer());
		
		final TicketStatusResDto ticketStatusResDto = new TicketStatusResDto();
		ticketStatusResDto.setData(ticketStatusDataDto);
		
		return ticketStatusResDto;
	}

}
