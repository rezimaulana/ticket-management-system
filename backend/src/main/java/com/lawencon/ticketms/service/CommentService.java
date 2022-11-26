package com.lawencon.ticketms.service;

import com.lawencon.ticketms.dto.comment.CommentInsertReqDto;
import com.lawencon.ticketms.dto.comment.CommentInsertResDto;
import com.lawencon.ticketms.dto.comment.CommentListResDto;
import com.lawencon.ticketms.dto.comment.CommentResDto;

public interface CommentService {
	CommentInsertResDto insert(CommentInsertReqDto data);
	CommentListResDto getAllIdTicket(Long id);
	CommentResDto getById(Long id);
	CommentListResDto getAllIdCommentWithFile(Long id);
}
