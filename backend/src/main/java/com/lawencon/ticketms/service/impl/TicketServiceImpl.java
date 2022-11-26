package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.constant.ResponseConst;
import com.lawencon.ticketms.constant.TicketStatusConst;
import com.lawencon.ticketms.dao.AttachTicketDao;
import com.lawencon.ticketms.dao.FileDao;
import com.lawencon.ticketms.dao.ProductCustomerDao;
import com.lawencon.ticketms.dao.TicketDao;
import com.lawencon.ticketms.dao.TicketPriorityDao;
import com.lawencon.ticketms.dao.TicketStatusDao;
import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.dto.ticket.TicketDataDto;
import com.lawencon.ticketms.dto.ticket.TicketInsertDataResDto;
import com.lawencon.ticketms.dto.ticket.TicketInsertReqDto;
import com.lawencon.ticketms.dto.ticket.TicketInsertResDto;
import com.lawencon.ticketms.dto.ticket.TicketListResDto;
import com.lawencon.ticketms.dto.ticket.TicketResDto;
import com.lawencon.ticketms.dto.ticket.TicketUpdateDataResDto;
import com.lawencon.ticketms.dto.ticket.TicketUpdateReqDto;
import com.lawencon.ticketms.dto.ticket.TicketUpdateResDto;
import com.lawencon.ticketms.model.AttachmentTicket;
import com.lawencon.ticketms.model.File;
import com.lawencon.ticketms.model.ProductCustomer;
import com.lawencon.ticketms.model.Ticket;
import com.lawencon.ticketms.model.TicketPriority;
import com.lawencon.ticketms.model.TicketStatus;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.pojo.SendEmailPojo;
import com.lawencon.ticketms.service.GenerateCodeService;
import com.lawencon.ticketms.service.JavaMailService;
import com.lawencon.ticketms.service.PrincipalService;
import com.lawencon.ticketms.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private TicketStatusDao ticketStatusDao;
	@Autowired
	private TicketPriorityDao ticketPriorityDao;
	@Autowired
	private ProductCustomerDao productCustomerDao;
	@Autowired
	private GenerateCodeService generateCodeService;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private AttachTicketDao attachTicketDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private JavaMailService mailService;
	@Autowired
	private PrincipalService principalService;
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public TicketInsertResDto insert(TicketInsertReqDto data) {
		Ticket insertOne = new Ticket();
		insertOne.setCode(generateCodeService.generateDigit());
		insertOne.setTitle(data.getTitle());
		insertOne.setContent(data.getContent());
		insertOne.setCreatedBy(principalService.getPrincipal().getId());
		final Optional<TicketStatus> status = ticketStatusDao.getByCode(TicketStatusConst.STATOP.getStatusCodeEnum());
		insertOne.setTicketStatus(status.get());
		final Optional<TicketPriority> priority = ticketPriorityDao.getByCode(data.getTicketPriorityCode());
		insertOne.setTicketPriority(priority.get());
		final Optional<ProductCustomer> productCustomer = productCustomerDao.getById(data.getProductCustomerId());
		insertOne.setProductCustomer(productCustomer.get());
		insertOne = ticketDao.insert(insertOne);
		
		if(data.getFile() != null) {
			for (int i=0; i<data.getFile().size(); i++) {
				final AttachmentTicket attachmentTicket = new AttachmentTicket();
				final File file = new File();
				file.setFileCode(data.getFile().get(i).getFileCode());
				file.setFileExt(data.getFile().get(i).getFileExt());
				file.setCreatedBy(principalService.getPrincipal().getId());
				
				final File files = fileDao.insert(file);
				attachmentTicket.setTicket(insertOne);
				attachmentTicket.setFile(files);
				attachmentTicket.setCreatedBy(principalService.getPrincipal().getId());
				attachTicketDao.insert(attachmentTicket);
			}
		}
		
		final TicketInsertDataResDto dto = new TicketInsertDataResDto();
		dto.setId(insertOne.getId());
		
		final SendEmailPojo emailPojo = new SendEmailPojo();
		final Optional<User> optional = userDao.getById(principalService.getPrincipal().getId());
        emailPojo.setEmail(optional.get().getPicId().getEmail());
        emailPojo.setSubject("Tiket Baru : "+insertOne.getCode());
        emailPojo.setBody("Pelanggan "+optional.get().getEmail()+" telah membuat tiket.");

        Runnable r = () -> mailService.sendEmail(emailPojo);
		Thread t = new Thread(r);
		t.start();

		final TicketInsertResDto resDto = new TicketInsertResDto();
		resDto.setData(dto);
		resDto.setMessage(ResponseConst.CREATED.toString()+" "+insertOne.getCode());
		
		return resDto;
	}
	
	@Override
	public TicketResDto getById(final Long id) {
		final Optional<Ticket> optional = ticketDao.getById(id);
		final Ticket ticket = optional.get();
		
		final TicketDataDto ticketDataDto = new TicketDataDto();
		ticketDataDto.setId(ticket.getId());
		ticketDataDto.setCode(ticket.getCode());
		ticketDataDto.setTitle(ticket.getTitle());
		ticketDataDto.setContent(ticket.getContent());
		ticketDataDto.setStatusCode(ticket.getTicketStatus().getStatusCode());
		ticketDataDto.setStatus(ticket.getTicketStatus().getStatus());
		ticketDataDto.setPriority(ticket.getTicketPriority().getPriority());
		ticketDataDto.setProductName(ticket.getProductCustomer().getProduct().getProductName());
		ticketDataDto.setVer(ticket.getVer());
		ticketDataDto.setIsActive(ticket.getIsActive());
		ticketDataDto.setCreatedAt(ticket.getCreatedAt());
		
		final TicketResDto ticketResDto = new TicketResDto();
		ticketResDto.setData(ticketDataDto);
		
		return ticketResDto;
	}

	@Override
	public TicketListResDto getAll() {
		final List<Ticket> tickets = ticketDao.getAll();
		final List<TicketDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<tickets.size(); i++) {
			final Ticket ticket = tickets.get(i);
			final TicketDataDto dto = new TicketDataDto();
			dto.setId(ticket.getId());
			dto.setCode(ticket.getCode());
			dto.setTitle(ticket.getTitle());
			dto.setContent(ticket.getContent());
			dto.setStatusCode(ticket.getTicketStatus().getStatusCode());
			dto.setStatus(ticket.getTicketStatus().getStatus());
			dto.setPriority(ticket.getTicketPriority().getPriority());
			dto.setProductName(ticket.getProductCustomer().getProduct().getProductName());
			dto.setCustomerName(ticket.getProductCustomer().getUser().getFullname());
			dto.setVer(ticket.getVer());
			dto.setIsActive(ticket.getIsActive());
			dto.setCreatedAt(ticket.getCreatedAt());
			dataDto.add(dto);
		}
		final TicketListResDto ticketListResDto = new TicketListResDto();
		ticketListResDto.setData(dataDto);
		return ticketListResDto;
	}

	@Override
	public TicketListResDto getAllIdCust(final Long id) {
		final List<Ticket> tickets = ticketDao.getAllIdCust(id);
		final List<TicketDataDto> dataDto = new ArrayList<>();
		for (int i=0; i<tickets.size(); i++) {
			final Ticket ticket = tickets.get(i);
			final TicketDataDto dto = new TicketDataDto();
			dto.setId(ticket.getId());
			dto.setCode(ticket.getCode());
			dto.setTitle(ticket.getTitle());
			dto.setContent(ticket.getContent());
			dto.setStatusCode(ticket.getTicketStatus().getStatusCode());
			dto.setStatus(ticket.getTicketStatus().getStatus());
			dto.setPriority(ticket.getTicketPriority().getPriority());
			dto.setProductName(ticket.getProductCustomer().getProduct().getProductName());
			dto.setVer(ticket.getVer());
			dto.setIsActive(ticket.getIsActive());
			dto.setCreatedAt(ticket.getCreatedAt());
			dataDto.add(dto);
		}
		final TicketListResDto ticketListResDto = new TicketListResDto();
		ticketListResDto.setData(dataDto);
		return ticketListResDto;
	}
	
	@Override
	public TicketListResDto getAllIdPic(final Long id) {
		final List<Ticket> tickets = ticketDao.getAllIdPic(id);
		final List<TicketDataDto> dataDto = new ArrayList<>();
		for (int i=0; i<tickets.size(); i++) {
			final Ticket ticket = tickets.get(i);
			final TicketDataDto dto = new TicketDataDto();
			dto.setId(ticket.getId());
			dto.setCode(ticket.getCode());
			dto.setTitle(ticket.getTitle());
			dto.setContent(ticket.getContent());
			dto.setStatusCode(ticket.getTicketStatus().getStatusCode());
			dto.setStatus(ticket.getTicketStatus().getStatus());
			dto.setPriority(ticket.getTicketPriority().getPriority());
			dto.setProductName(ticket.getProductCustomer().getProduct().getProductName());
			dto.setCustomerName(ticket.getProductCustomer().getUser().getFullname());
			dto.setVer(ticket.getVer());
			dto.setIsActive(ticket.getIsActive());
			dto.setCreatedAt(ticket.getCreatedAt());
			dataDto.add(dto);
		}
		final TicketListResDto ticketListResDto = new TicketListResDto();
		ticketListResDto.setData(dataDto);
		return ticketListResDto;
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public TicketUpdateResDto updateStatus(TicketUpdateReqDto data) {
		Optional<Ticket> getData = ticketDao.getById(data.getId());
		final Optional<TicketStatus> close = ticketStatusDao.getByCode(TicketStatusConst.STATCL.getStatusCodeEnum());
		final Optional<TicketStatus> reopen = ticketStatusDao.getByCode(TicketStatusConst.STATRO.getStatusCodeEnum());
		final Optional<TicketStatus> open = ticketStatusDao.getByCode(TicketStatusConst.STATOP.getStatusCodeEnum());
		Ticket ticket = new Ticket();
		ticket.setId(data.getId());
		ticket.setCode(getData.get().getCode());
		ticket.setTitle(getData.get().getTitle());
		ticket.setContent(getData.get().getContent());
		if(getData.get().getTicketStatus().getId() == open.get().getId()) {
			ticket.setTicketStatus(close.get());
		} else if(getData.get().getTicketStatus().getId() == close.get().getId()) {
			ticket.setTicketStatus(reopen.get());
		} else if(getData.get().getTicketStatus().getId() == reopen.get().getId()) {
			ticket.setTicketStatus(close.get());
		} else {
			ticket.setTicketStatus(open.get());
		}
		final Optional<TicketPriority> tp = ticketPriorityDao.getById(getData.get().getTicketPriority().getId());
		ticket.setTicketPriority(tp.get());
		final Optional<ProductCustomer> pc = productCustomerDao.getById(getData.get().getProductCustomer().getId());
		ticket.setProductCustomer(pc.get());
		ticket.setCreatedBy(getData.get().getCreatedBy());
		ticket.setCreatedAt(getData.get().getCreatedAt());
		ticket.setUpdatedBy(principalService.getPrincipal().getId());
		ticket.setVer(data.getVer());
		ticket.setIsActive(getData.get().getIsActive());
		ticket = ticketDao.updateStatus(ticket);
		final TicketUpdateDataResDto dto = new TicketUpdateDataResDto();
		dto.setVer(ticket.getVer());
		final TicketUpdateResDto resDto = new TicketUpdateResDto();
		resDto.setData(dto);
		resDto.setMessage(ResponseConst.UPDATED.getResponse());
		return resDto;
	}
}