package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.dao.AttachTicketDao;
import com.lawencon.ticketms.dto.attachmentticket.AttachmentTicketDataDto;
import com.lawencon.ticketms.dto.attachmentticket.AttachmentTicketListResDto;
import com.lawencon.ticketms.dto.attachmentticket.AttachmentTicketResDto;
import com.lawencon.ticketms.model.AttachmentTicket;
import com.lawencon.ticketms.service.AttachTicketService;

@Service
public class AttachTicketServiceImpl implements AttachTicketService{
	
	@Autowired
	private AttachTicketDao attachTicketDao;
	
	@Override
	public AttachmentTicketResDto getById(final Long id) {
		final Optional<AttachmentTicket> optional = attachTicketDao.getById(id);
		final AttachmentTicket attachmentTicket = optional.get();
		
		final AttachmentTicketDataDto attachmentTicketDataDto = new AttachmentTicketDataDto();
		attachmentTicketDataDto.setId(attachmentTicket.getId());
		attachmentTicketDataDto.setFileId(attachmentTicket.getFile().getId());
		attachmentTicketDataDto.setTicketId(attachmentTicket.getTicket().getId());
		attachmentTicketDataDto.setVer(attachmentTicket.getVer());
		
		final AttachmentTicketResDto attachmentTicketResDto = new AttachmentTicketResDto();
		attachmentTicketResDto.setData(attachmentTicketDataDto);
		
		return attachmentTicketResDto;
	}

	@Override
	public AttachmentTicketListResDto getAll() {
		final List<AttachmentTicket> attachmentTickets = attachTicketDao.getAll();
		final List<AttachmentTicketDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<attachmentTickets.size(); i++) {
			final AttachmentTicket attachmentTicket = attachmentTickets.get(i);
			final AttachmentTicketDataDto dto = new AttachmentTicketDataDto();
			dto.setId(attachmentTicket.getId());
			dto.setFileId(attachmentTicket.getFile().getId());
			dto.setTicketId(attachmentTicket.getTicket().getId());
			dto.setVer(attachmentTicket.getVer());
			dataDto.add(dto);
		}
		final AttachmentTicketListResDto attachmentTicketListResDto = new AttachmentTicketListResDto();
		attachmentTicketListResDto.setData(dataDto);
		return attachmentTicketListResDto;
	}

	@Override
	public AttachmentTicketListResDto getAllIdTicket(final Long id) {
		final List<AttachmentTicket> attachmentTickets = attachTicketDao.getAllIdTicket(id);
		final List<AttachmentTicketDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<attachmentTickets.size(); i++) {
			final AttachmentTicket attachmentTicket = attachmentTickets.get(i);
			final AttachmentTicketDataDto dto = new AttachmentTicketDataDto();
			dto.setId(attachmentTicket.getId());
			dto.setFileId(attachmentTicket.getFile().getId());
			dto.setTicketId(attachmentTicket.getTicket().getId());
			dto.setVer(attachmentTicket.getVer());
			dataDto.add(dto);
		}
		final AttachmentTicketListResDto attachmentTicketListResDto = new AttachmentTicketListResDto();
		attachmentTicketListResDto.setData(dataDto);
		return attachmentTicketListResDto;
	}

}
