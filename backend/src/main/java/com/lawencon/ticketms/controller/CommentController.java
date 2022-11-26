package com.lawencon.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.ticketms.dto.comment.CommentInsertReqDto;
import com.lawencon.ticketms.dto.comment.CommentInsertResDto;
import com.lawencon.ticketms.dto.comment.CommentListResDto;
import com.lawencon.ticketms.dto.comment.CommentResDto;
import com.lawencon.ticketms.service.CommentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("{id}")
	public ResponseEntity<CommentResDto> getById(@PathVariable("id") Long id){
		final CommentResDto result = commentService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("ticket/{id}")
	public ResponseEntity<CommentListResDto> getAllIdCust(@PathVariable("id") Long id) {
		final CommentListResDto result = commentService.getAllIdTicket(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CommentInsertResDto> insert(@RequestBody CommentInsertReqDto data){
		final CommentInsertResDto result = commentService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("with_file_by_ticket/{id}")
	public ResponseEntity<CommentListResDto> getAllIdCommentWithFile(@PathVariable("id") Long id) {
		final CommentListResDto result = commentService.getAllIdCommentWithFile(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
