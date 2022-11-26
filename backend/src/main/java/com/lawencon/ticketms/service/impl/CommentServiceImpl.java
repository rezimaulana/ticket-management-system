package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.constant.ResponseConst;
import com.lawencon.ticketms.dao.AttachCommentDao;
import com.lawencon.ticketms.dao.CommentDao;
import com.lawencon.ticketms.dao.FileDao;
import com.lawencon.ticketms.dao.TicketDao;
import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.dto.comment.CommentDataDto;
import com.lawencon.ticketms.dto.comment.CommentInsertDataResDto;
import com.lawencon.ticketms.dto.comment.CommentInsertReqDto;
import com.lawencon.ticketms.dto.comment.CommentInsertResDto;
import com.lawencon.ticketms.dto.comment.CommentListResDto;
import com.lawencon.ticketms.dto.comment.CommentResDto;
import com.lawencon.ticketms.model.AttachmentComment;
import com.lawencon.ticketms.model.Comment;
import com.lawencon.ticketms.model.File;
import com.lawencon.ticketms.model.Ticket;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.service.CommentService;
import com.lawencon.ticketms.service.PrincipalService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AttachCommentDao attachCommentDao;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private PrincipalService principalService;
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public CommentInsertResDto insert(CommentInsertReqDto data) {
		Comment insertOne = new Comment();
		insertOne.setComments(data.getComments());
		final Optional<Ticket> ticket = ticketDao.getById(data.getTicketId());
		insertOne.setTicket(ticket.get());
		final Optional<User> user = userDao.getById(principalService.getPrincipal().getId());
		insertOne.setUser(user.get());
		insertOne.setCreatedBy(principalService.getPrincipal().getId());
		insertOne= commentDao.insert(insertOne);
		if (data.getFile() != null) {
			for (int i=0; i<data.getFile().size(); i++) {
				final AttachmentComment attachmentComment = new AttachmentComment();
				final File file = new File();
				file.setFileCode(data.getFile().get(i).getFileCode());
				file.setFileExt(data.getFile().get(i).getFileExt());
				file.setCreatedBy(principalService.getPrincipal().getId());
				
				final File files = fileDao.insert(file);
				attachmentComment.setComment(insertOne);
				attachmentComment.setFile(files);
				attachmentComment.setCreatedBy(principalService.getPrincipal().getId());
				attachCommentDao.insert(attachmentComment);
			}			
		}
		
		final CommentInsertDataResDto dto = new CommentInsertDataResDto();
		dto.setId(insertOne.getId());

		final CommentInsertResDto resDto = new CommentInsertResDto();
		resDto.setData(dto);
		resDto.setMessage(ResponseConst.CREATED.toString());

		return resDto;
	}
	
	@Override
	public CommentListResDto getAllIdTicket(final Long id) {
		final List<Comment> comments = commentDao.getAllIdTicket(id);
		final List<CommentDataDto> dataDto = new ArrayList<>();
		for (int i=0; i<comments.size(); i++) {
			final Comment comment = comments.get(i);
			final CommentDataDto dto = new CommentDataDto();
			dto.setId(comment.getId());
			dto.setComments(comment.getComments());
			dto.setTicketId(comment.getTicket().getId());
			dto.setUserId(comment.getUser().getId());
			dto.setFullname(comment.getUser().getFullname());
			dto.setCreatedAt(comment.getCreatedAt());
			dto.setVer(comment.getVer());
			dataDto.add(dto);
		}
		final CommentListResDto commentListResDto = new CommentListResDto();
		commentListResDto.setData(dataDto);
		return commentListResDto;
	}

	@Override
	public CommentResDto getById(final Long id) {
		final Optional<Comment> optional = commentDao.getById(id);
		final Comment comment = optional.get();
		
		final CommentDataDto commentDataDto = new CommentDataDto();
		commentDataDto.setId(comment.getId());
		commentDataDto.setComments(comment.getComments());
		commentDataDto.setTicketId(comment.getTicket().getId());
		commentDataDto.setUserId(comment.getUser().getId());
		commentDataDto.setFullname(comment.getUser().getFullname());
		commentDataDto.setCreatedAt(comment.getCreatedAt());
		commentDataDto.setVer(comment.getVer());
		
		final CommentResDto commentResDto = new CommentResDto();
		commentResDto.setData(commentDataDto);
		
		return commentResDto;
	}

	@Override
	public CommentListResDto getAllIdCommentWithFile(Long id) {
		final List<Comment> comments = commentDao.getAllIdTicket(id);
		final List<CommentDataDto> dataDto = new ArrayList<>();
//		final List<FileListResDto> flDto = new ArrayList<>();
		for (int i=0; i<comments.size(); i++) {
			final Comment comment = comments.get(i);
			final CommentDataDto dto = new CommentDataDto();
			dto.setId(comment.getId());
			dto.setComments(comment.getComments());
			dto.setTicketId(comment.getTicket().getId());
			dto.setUserId(comment.getUser().getId());
			dto.setFullname(comment.getUser().getFullname());
			if (comment.getUser().getFile()!=null) {
				dto.setPhotoId(comment.getUser().getFile().getId());				
			}
			dto.setCreatedAt(comment.getCreatedAt());
			dto.setVer(comment.getVer());
			
			final List<AttachmentComment> file = attachCommentDao.getAllIdComment(comment.getId());
			List<Long> fileId = new ArrayList<>();
			for (int j=0; j<file.size(); j++) {
				fileId.add(file.get(j).getId());
				dto.setFileId(fileId);
			}
			
			dataDto.add(dto);
		}
		final CommentListResDto commentListResDto = new CommentListResDto();
		commentListResDto.setData(dataDto);
		return commentListResDto;
	}
	
}
