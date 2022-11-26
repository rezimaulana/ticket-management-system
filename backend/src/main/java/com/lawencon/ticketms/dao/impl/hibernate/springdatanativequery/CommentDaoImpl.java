package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.CommentDao;
import com.lawencon.ticketms.model.Comment;
import com.lawencon.ticketms.repository.nativequery.CommentRepositoryNative;

@Repository
@Profile("datanative")
public class CommentDaoImpl extends BaseDaoImpl implements CommentDao{
	
	@Autowired
	private CommentRepositoryNative repository;
	
	@Override
	public Comment insert(final Comment data)  {
		return repository.save(data);
	}

	@Override
	public Comment update(final Comment data)  {
		return repository.saveAndFlush(data);
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
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public List<Comment> getAllIdTicket(final Long id)  {
//		final List<?> result = repository.getAllIdTicket(id);
//		final List<Comment> comments =  new ArrayList<>();
//		if(result != null && result.size() > 0) {
//			result.forEach(objCol -> {
//				Object[] objArr = (Object[]) objCol;
//				final Comment comment = new Comment();
//	            comment.setId(Long.valueOf(objArr[0].toString()));
//	            comment.setComments(objArr[1].toString());
//	            comment.setCreatedAt(Timestamp.valueOf(objArr[11].toString()).toLocalDateTime());
//	            comment.setVer(Integer.valueOf(objArr[12].toString()));
//	            final Ticket ticket = new Ticket();
//				ticket.setId(Long.valueOf(objArr[2].toString()));
//				ticket.setCode(objArr[3].toString());
//				ticket.setTitle(objArr[4].toString());
//				ticket.setContent(objArr[5].toString());
//				final TicketStatus ticketStatus = new TicketStatus();
//				ticketStatus.setStatus(objArr[6].toString());
//				ticketStatus.setStatusCode(objArr[7].toString());
//				ticket.setTicketStatus(ticketStatus);
//				final TicketPriority ticketPriority = new TicketPriority();
//				ticketPriority.setPriority(objArr[8].toString());
//				ticket.setTicketPriority(ticketPriority);
//				final ProductCustomer productCustomer = new ProductCustomer();
//				final Product product = new Product();
//				product.setProductName(objArr[9].toString());
//				productCustomer.setProduct(product);
//				ticket.setProductCustomer(productCustomer);
//				final User user = new User();
//				user.setFullname(objArr[10].toString());
//				comment.setUser(user);
//				comment.setTicket(ticket);
//	            comments.add(comment);
//			});
//		}
//		return comments;
		return repository.getAllIdTicket(id);
	}

}
