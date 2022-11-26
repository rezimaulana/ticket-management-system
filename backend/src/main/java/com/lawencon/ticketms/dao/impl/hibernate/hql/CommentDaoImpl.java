package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.CommentDao;
import com.lawencon.ticketms.model.Comment;

@Repository
@Profile("hql")
public class CommentDaoImpl extends BaseDaoImpl implements CommentDao{
	
	@Override
	public Comment insert(final Comment data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Comment update(final Comment data)  {
		final Comment updateOne = this.em.merge(data);
		this.em.flush();	
		return updateOne;
	}

	@Override
	public Optional<Comment> getById(final Long id)  {
		final Comment comment = this.em.find(Comment.class, id);
		em.detach(comment);
		final Optional<Comment> commentOptional = Optional.ofNullable(comment);
		return commentOptional;
	}

	@Override
	public List<Comment> getAll()  {
		final String sql = " SELECT c "
				+ "	FROM Comment c ";
		final List<Comment> comment = this.em.createQuery(sql, Comment.class).getResultList();
		return comment;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM Comment WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public List<Comment> getAllIdTicket(final Long id)  {
		final String sql = "SELECT c "
				+ "FROM Comment c "
				+ "INNER JOIN FETCH c.ticket t "
				+ "INNER JOIN t.ticketPriority tp "
				+ "INNER JOIN t.ticketStatus ts "
				+ "INNER JOIN t.productCustomer pc "
				+ "INNER JOIN pc.product p "
				+ "INNER JOIN c.user u "
				+ "LEFT JOIN u.file f "
				+ "WHERE t.id = :id "
				+ "ORDER BY c.createdAt DESC";
		final List<Comment> result = this.em.createQuery(sql, Comment.class)
				.setParameter("id", id).getResultList();
		return result;
	}

}
