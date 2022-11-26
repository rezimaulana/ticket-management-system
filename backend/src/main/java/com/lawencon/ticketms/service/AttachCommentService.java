package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.attachmentcomment.AttachmentCommentListResDto;
import com.lawencon.ticketms.dto.attachmentcomment.AttachmentCommentResDto;

public interface AttachCommentService {
	AttachmentCommentResDto getById(Long id);
	AttachmentCommentListResDto getAll();
	AttachmentCommentListResDto getAllIdComment(Long id);
}
