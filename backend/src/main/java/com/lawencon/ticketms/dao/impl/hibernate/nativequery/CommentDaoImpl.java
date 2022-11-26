package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.CommentDao;
import com.lawencon.ticketms.model.Comment;

@Repository
@Profile("native")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM comments c ";
		final List<Comment> comment = this.em.createNativeQuery(sql, Comment.class).getResultList();
		return comment;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM comments WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllIdTicket(final Long id)  {
		final String sql = "SELECT * "
				+ "FROM comments c "
				+ "INNER JOIN tickets t ON c.ticket_id = t.id "
				+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
				+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
				+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
				+ "INNER JOIN products p ON pc.product_id = p.id "
				+ "INNER JOIN users u ON u.id = c.user_id "
				+ "LEFT JOIN files f ON f.id = u.photo_id "
				+ "WHERE c.ticket_id = :id "
				+ "ORDER BY c.created_at DESC";
		final List<Comment> result = this.em.createNativeQuery(sql, Comment.class)
				.setParameter("id", id).getResultList();
		return result;
	}

}

//@Override
//public List<Comment> getAllIdTicket(final Long id)  {
//	final String sql = "SELECT c.id AS c_id, c.comments AS c_comment, "
//			+ "t.id AS t_id, t.code AS t_code, t.title AS t_title, t.content AS t_content, "
//			+ "ts.status AS ts_status, ts.status_code AS ts_code, tp.priority AS tp_priority, "
//			+ "p.product_name AS p_name, u.fullname AS u_fullname, c.created_at AS c_created_at, c.ver AS c_ver "
//			+ "FROM comments c "
//			+ "INNER JOIN tickets t ON c.ticket_id = t.id "
//			+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
//			+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
//			+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
//			+ "INNER JOIN products p ON pc.product_id = p.id "
//			+ "INNER JOIN users u ON u.id = c.user_id "
//			+ "WHERE c.ticket_id = :id "
//			+ "ORDER BY c.created_at DESC";
//	final List<?> result = this.em.createNativeQuery(sql)
//			.setParameter("id", id).getResultList();
//	final List<Comment> comments =  new ArrayList<>();
//	if(result != null && result.size() > 0) {
//		result.forEach(objCol -> {
//			Object[] objArr = (Object[]) objCol;
//			final Comment comment = new Comment();
//            comment.setId(Long.valueOf(objArr[0].toString()));
//            comment.setComments(objArr[1].toString());
//            comment.setCreatedAt(Timestamp.valueOf(objArr[11].toString()).toLocalDateTime());
//            comment.setVer(Integer.valueOf(objArr[12].toString()));
//            final Ticket ticket = new Ticket();
//			ticket.setId(Long.valueOf(objArr[2].toString()));
//			ticket.setCode(objArr[3].toString());
//			ticket.setTitle(objArr[4].toString());
//			ticket.setContent(objArr[5].toString());
//			final TicketStatus ticketStatus = new TicketStatus();
//			ticketStatus.setStatus(objArr[6].toString());
//			ticketStatus.setStatusCode(objArr[7].toString());
//			ticket.setTicketStatus(ticketStatus);
//			final TicketPriority ticketPriority = new TicketPriority();
//			ticketPriority.setPriority(objArr[8].toString());
//			ticket.setTicketPriority(ticketPriority);
//			final ProductCustomer productCustomer = new ProductCustomer();
//			final Product product = new Product();
//			product.setProductName(objArr[9].toString());
//			productCustomer.setProduct(product);
//			ticket.setProductCustomer(productCustomer);
//			final User user = new User();
//			user.setFullname(objArr[10].toString());
//			comment.setUser(user);
//			comment.setTicket(ticket);
//            comments.add(comment);
//		});
//	}
//	return comments;
//}
