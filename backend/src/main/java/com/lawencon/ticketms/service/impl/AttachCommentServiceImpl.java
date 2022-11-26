package com.lawencon.ticketms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.ticketms.dao.AttachCommentDao;
import com.lawencon.ticketms.dto.attachmentcomment.AttachmentCommentDataDto;
import com.lawencon.ticketms.dto.attachmentcomment.AttachmentCommentListResDto;
import com.lawencon.ticketms.dto.attachmentcomment.AttachmentCommentResDto;
import com.lawencon.ticketms.model.AttachmentComment;
import com.lawencon.ticketms.service.AttachCommentService;

@Service
public class AttachCommentServiceImpl implements AttachCommentService{

	@Autowired
	private AttachCommentDao attachCommentDao;
	
	@Override
	public AttachmentCommentResDto getById(final Long id) {
		final Optional<AttachmentComment> optional = attachCommentDao.getById(id);
		final AttachmentComment attachmentComment = optional.get();
		
		final AttachmentCommentDataDto attachmentCommentDataDto = new AttachmentCommentDataDto();
		attachmentCommentDataDto.setId(attachmentComment.getId());
		attachmentCommentDataDto.setFileId(attachmentComment.getFile().getId());
		attachmentCommentDataDto.setCommentId(attachmentComment.getComment().getId());
		attachmentCommentDataDto.setVer(attachmentComment.getVer());
		
		final AttachmentCommentResDto attachmentCommentResDto = new AttachmentCommentResDto();
		attachmentCommentResDto.setData(attachmentCommentDataDto);
		
		return attachmentCommentResDto;
	}

	@Override
	public AttachmentCommentListResDto getAll() {
		final List<AttachmentComment> attachmentComments = attachCommentDao.getAll();
		final List<AttachmentCommentDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<attachmentComments.size(); i++) {
			final AttachmentComment attachmentComment = attachmentComments.get(i);
			final AttachmentCommentDataDto dto = new AttachmentCommentDataDto();
			dto.setId(attachmentComment.getId());
			dto.setFileId(attachmentComment.getFile().getId());
			dto.setCommentId(attachmentComment.getComment().getId());
			dto.setVer(attachmentComment.getVer());
			dataDto.add(dto);
		}
		final AttachmentCommentListResDto attachmentCommentListResDto = new AttachmentCommentListResDto();
		attachmentCommentListResDto.setData(dataDto);
		return attachmentCommentListResDto;
	}

	@Override
	public AttachmentCommentListResDto getAllIdComment(final Long id) {
		final List<AttachmentComment> attachmentComments = attachCommentDao.getAllIdComment(id);
		final List<AttachmentCommentDataDto> dataDto = new ArrayList<>();
		for (int i = 0; i<attachmentComments.size(); i++) {
			final AttachmentComment attachmentComment = attachmentComments.get(i);
			final AttachmentCommentDataDto dto = new AttachmentCommentDataDto();
			dto.setId(attachmentComment.getId());
			dto.setFileId(attachmentComment.getFile().getId());
			dto.setCommentId(attachmentComment.getComment().getId());
			dto.setVer(attachmentComment.getVer());
			dataDto.add(dto);
		}
		final AttachmentCommentListResDto attachmentCommentListResDto = new AttachmentCommentListResDto();
		attachmentCommentListResDto.setData(dataDto);
		return attachmentCommentListResDto;
	}

}
