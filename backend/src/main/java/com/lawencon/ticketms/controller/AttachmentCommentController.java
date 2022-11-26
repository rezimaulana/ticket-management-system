package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.attachmentcomment.AttachmentCommentListResDto;
import com.lawencon.ticketms.dto.attachmentcomment.AttachmentCommentResDto;
import com.lawencon.ticketms.service.AttachCommentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("attachments_comment")
public class AttachmentCommentController {
	
	@Autowired
	private AttachCommentService attachCommentService;
	
	@GetMapping
	public ResponseEntity<AttachmentCommentListResDto> getAll() {
		final AttachmentCommentListResDto result = attachCommentService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AttachmentCommentResDto> getById(@PathVariable("id") Long id){
		final AttachmentCommentResDto result = attachCommentService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("comment/{id}")
	public ResponseEntity<AttachmentCommentListResDto> getAllIdComment(@PathVariable("id") Long id) {
		final AttachmentCommentListResDto result = attachCommentService.getAllIdComment(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}

