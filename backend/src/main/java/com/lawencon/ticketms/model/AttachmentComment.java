package com.lawencon.ticketms.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attachments_comment")
public class AttachmentComment extends BaseModel{
	
	@ManyToOne
	@JoinColumn(name = "file_id", nullable=false)
	private File file;
	@ManyToOne
	@JoinColumn(name = "comment_id", nullable=false)
	private Comment comment;
	
	public File getFile() {
		return file;
	}
	public void setFile(final File file) {
		this.file = file;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(final Comment comment) {
		this.comment = comment;
	}
}
