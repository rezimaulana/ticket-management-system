package com.lawencon.ticketms.dao;

import java.util.List;

import com.lawencon.ticketms.model.AttachmentComment;

public interface AttachCommentDao extends BaseDao<AttachmentComment>{
	List<AttachmentComment> getAllIdComment(long id);
}
