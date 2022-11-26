package com.lawencon.ticketms.dao;

import java.util.List;

import com.lawencon.ticketms.model.Comment;

public interface CommentDao extends BaseDao<Comment>{
	List<Comment> getAllIdTicket(Long id);
}
