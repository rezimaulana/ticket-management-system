package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketDao;
import com.lawencon.ticketms.model.Product;
import com.lawencon.ticketms.model.ProductCustomer;
import com.lawencon.ticketms.model.Ticket;
import com.lawencon.ticketms.model.TicketPriority;
import com.lawencon.ticketms.model.TicketStatus;

@Repository
@Profile("native")
public class TicketDaoImpl extends BaseDaoImpl implements TicketDao {
	
	@Override
	public Ticket insert(final Ticket data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public Ticket update(final Ticket data)  {
		final Ticket updateOne = this.em.merge(data);
		this.em.flush();	
		return updateOne;
	}

	@Override
	public Optional<Ticket> getById(final Long id)  {
		final String sql = "SELECT t.id AS t_id, t.code AS t_code, t.title AS t_title, t.content AS t_content, "
				+ "ts.status AS ts_status, ts.status_code AS ts_code, tp.priority AS tp_priority, p.product_name AS p_name, "
				+ "t.ver as ver, ts.id as ts_id, tp.id as tp_id, tp.priority_code as tp_code, pc.id AS pc_id, "
				+ "t.created_by as t_created_by, t.created_at as t_created_at, t.is_active AS t_is_active "
				+ "FROM tickets t "
				+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
				+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
				+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
				+ "INNER JOIN products p ON pc.product_id = p.id "
				+ "WHERE t.id = :id";
		Ticket ticket = null;
		TicketStatus ticketStatus = null;
		TicketPriority ticketPriority = null;
		ProductCustomer productCustomer = null;
		Product product = null;
		try {			
			final Object objCol = this.em.createNativeQuery(sql)
					.setParameter("id", id).getSingleResult();
			if(objCol !=null) {
				Object[] objArr = (Object[]) objCol;
				ticket = new Ticket();
				ticket.setId(Long.valueOf(objArr[0].toString()));
				ticket.setCode(objArr[1].toString());
				ticket.setTitle(objArr[2].toString());
				ticket.setContent(objArr[3].toString());
				ticket.setVer(Integer.valueOf(objArr[8].toString()));
				ticket.setCreatedBy(Long.valueOf(objArr[13].toString()));
				ticket.setCreatedAt(Timestamp.valueOf(objArr[14].toString()).toLocalDateTime());
				ticket.setIsActive(Boolean.valueOf(objArr[15].toString()));
				ticketStatus = new TicketStatus();
				ticketStatus.setId(Long.valueOf(objArr[9].toString()));
				ticketStatus.setStatus(objArr[4].toString());
				ticketStatus.setStatusCode(objArr[5].toString());
				ticket.setTicketStatus(ticketStatus);
				ticketPriority = new TicketPriority();
				ticketPriority.setId(Long.valueOf(objArr[10].toString()));
				ticketPriority.setPriorityCode(objArr[11].toString());
				ticketPriority.setPriority(objArr[6].toString());
				ticket.setTicketPriority(ticketPriority);
				productCustomer = new ProductCustomer();
				product = new Product();
				product.setProductName(objArr[7].toString());
				productCustomer.setId(Long.valueOf(objArr[12].toString()));
				productCustomer.setProduct(product);
				ticket.setProductCustomer(productCustomer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.em.detach(ticket);
		final Optional<Ticket> ticketOptional = Optional.ofNullable(ticket);;
		return ticketOptional;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM tickets t ";
		final List<Ticket> ticket = this.em.createNativeQuery(sql, Ticket.class).getResultList();
		return ticket;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM tickets WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getAllIdCust(final Long id)  {
		final String sql = "SELECT * "
				+ "FROM tickets t "
				+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
				+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
				+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
				+ "INNER JOIN products p ON pc.product_id = p.id "
				+ "WHERE pc.customer_id = :id";
		final List<Ticket> result = this.em.createNativeQuery(sql, Ticket.class)
				.setParameter("id", id).getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getAllIdPic(Long id)  {
		final String sql = "SELECT * "
				+ "FROM tickets t "
				+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
				+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
				+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
				+ "INNER JOIN products p ON pc.product_id = p.id "
				+ "INNER JOIN users u ON u.id = pc.customer_id "
				+ "WHERE u.pic_id = :id";
		final List<Ticket> result = this.em.createNativeQuery(sql, Ticket.class)
				.setParameter("id", id).getResultList();
		return result;
	}

	@Override
	public Ticket updateStatus(final Ticket data)  {
		final Ticket updateOne = this.em.merge(data);
		this.em.flush();	
		return updateOne;
	}

}

//@Override
//public List<Ticket> getAllIdPic(Long id)  {
//	final String sql = "SELECT t.id AS t_id, t.code AS t_code, t.title AS t_title, t.content AS t_content, "
//			+ "ts.status AS ts_status, ts.status_code AS ts_code, tp.priority AS tp_priority, "
//			+ "p.product_name AS p_name, u.fullname AS u_fullname, t.ver AS t_ver "
//			+ "FROM tickets t "
//			+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
//			+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
//			+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
//			+ "INNER JOIN products p ON pc.product_id = p.id "
//			+ "INNER JOIN users u ON u.id = pc.customer_id "
//			+ "WHERE u.pic_id = :id";
//	final List<?> result = this.em.createNativeQuery(sql)
//			.setParameter("id", id).getResultList();
//	final List<Ticket> tickets =  new ArrayList<>();
//	if(result != null && result.size() > 0) {
//		result.forEach(objCol -> {
//			Object[] objArr = (Object[]) objCol;
//			final Ticket ticket = new Ticket();
//			ticket.setId(Long.valueOf(objArr[0].toString()));
//			ticket.setCode(objArr[1].toString());
//			ticket.setTitle(objArr[2].toString());
//			ticket.setContent(objArr[3].toString());
//			ticket.setVer(Integer.valueOf(objArr[9].toString()));
//			final TicketStatus ticketStatus = new TicketStatus();
//			ticketStatus.setStatus(objArr[4].toString());
//			ticketStatus.setStatusCode(objArr[5].toString());
//			ticket.setTicketStatus(ticketStatus);
//			final TicketPriority ticketPriority = new TicketPriority();
//			ticketPriority.setPriority(objArr[6].toString());
//			ticket.setTicketPriority(ticketPriority);
//			final ProductCustomer productCustomer = new ProductCustomer();
//			final Product product = new Product();
//			product.setProductName(objArr[7].toString());
//			productCustomer.setProduct(product);
//			final User user = new User();
//			user.setFullname(objArr[8].toString());
//			productCustomer.setUser(user);
//			ticket.setProductCustomer(productCustomer);
//			tickets.add(ticket);
//		});
//	}
//	return tickets;
//}

//@Override
//public List<Ticket> getAllIdCust(final Long id)  {
//	final String sql = "SELECT t.id AS t_id, t.code AS t_code, t.title AS t_title, t.content AS t_content, "
//			+ "ts.status AS ts_status, ts.status_code AS ts_code, tp.priority AS tp_priority, p.product_name AS p_name, "
//			+ "t.ver AS t_ver "
//			+ "FROM tickets t "
//			+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
//			+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
//			+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
//			+ "INNER JOIN products p ON pc.product_id = p.id "
//			+ "WHERE pc.customer_id = :id";
//	final List<?> result = this.em.createNativeQuery(sql)
//			.setParameter("id", id).getResultList();
//	final List<Ticket> tickets =  new ArrayList<>();
//	if(result != null && result.size() > 0) {
//		result.forEach(objCol -> {
//			Object[] objArr = (Object[]) objCol;
//			final Ticket ticket = new Ticket();
//			ticket.setId(Long.valueOf(objArr[0].toString()));
//			ticket.setCode(objArr[1].toString());
//			ticket.setTitle(objArr[2].toString());
//			ticket.setContent(objArr[3].toString());
//			ticket.setVer(Integer.valueOf(objArr[8].toString()));
//			final TicketStatus ticketStatus = new TicketStatus();
//			ticketStatus.setStatus(objArr[4].toString());
//			ticketStatus.setStatusCode(objArr[5].toString());
//			ticket.setTicketStatus(ticketStatus);
//			final TicketPriority ticketPriority = new TicketPriority();
//			ticketPriority.setPriority(objArr[6].toString());
//			ticket.setTicketPriority(ticketPriority);
//			final ProductCustomer productCustomer = new ProductCustomer();
//			final Product product = new Product();
//			product.setProductName(objArr[7].toString());
//			productCustomer.setProduct(product);
//			ticket.setProductCustomer(productCustomer);
//			tickets.add(ticket);
//		});
//	}
//	return tickets;
//}
