package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.dao.TicketDao;
import com.lawencon.ticketms.model.Product;
import com.lawencon.ticketms.model.ProductCustomer;
import com.lawencon.ticketms.model.Ticket;
import com.lawencon.ticketms.model.TicketPriority;
import com.lawencon.ticketms.model.TicketStatus;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.repository.nativequery.TicketRepositoryNative;

@Repository
@Profile("datanative")
public class TicketDaoImpl extends BaseDaoImpl implements TicketDao {
	
	@Autowired
	private TicketRepositoryNative repository;
	
	@Override
	public Ticket insert(final Ticket data)  {
		return repository.save(data);
	}

	@Override
	public Ticket update(final Ticket data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<Ticket> getById(final Long id)  {
		final Ticket ticket = this.em.find(Ticket.class, id);
		em.detach(ticket);
		final Optional<Ticket> optional = Optional.ofNullable(ticket);
		return optional;
	}

	@Override
	public List<Ticket> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public List<Ticket> getAllIdCust(final Long id)  {
		final List<?> result = repository.getAllIdCust(id);
		final List<Ticket> tickets =  new ArrayList<>();
		if(result != null && result.size() > 0) {
			result.forEach(objCol -> {
				Object[] objArr = (Object[]) objCol;
				final Ticket ticket = new Ticket();
				ticket.setId(Long.valueOf(objArr[0].toString()));
				ticket.setCode(objArr[1].toString());
				ticket.setTitle(objArr[2].toString());
				ticket.setContent(objArr[3].toString());
				ticket.setVer(Integer.valueOf(objArr[8].toString()));
				final TicketStatus ticketStatus = new TicketStatus();
				ticketStatus.setStatus(objArr[4].toString());
				ticketStatus.setStatusCode(objArr[5].toString());
				ticket.setTicketStatus(ticketStatus);
				final TicketPriority ticketPriority = new TicketPriority();
				ticketPriority.setPriority(objArr[6].toString());
				ticket.setTicketPriority(ticketPriority);
				final ProductCustomer productCustomer = new ProductCustomer();
				final Product product = new Product();
				product.setProductName(objArr[7].toString());
				productCustomer.setProduct(product);
				ticket.setProductCustomer(productCustomer);
				tickets.add(ticket);
			});
		}
		return tickets;
	}

	@Override
	public Ticket updateStatus(final Ticket data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public List<Ticket> getAllIdPic(Long id)  {
		final List<?> result = repository.getAllIdPic(id);
		final List<Ticket> tickets =  new ArrayList<>();
		if(result != null && result.size() > 0) {
			result.forEach(objCol -> {
				Object[] objArr = (Object[]) objCol;
				final Ticket ticket = new Ticket();
				ticket.setId(Long.valueOf(objArr[0].toString()));
				ticket.setCode(objArr[1].toString());
				ticket.setTitle(objArr[2].toString());
				ticket.setContent(objArr[3].toString());
				ticket.setVer(Integer.valueOf(objArr[9].toString()));
				final TicketStatus ticketStatus = new TicketStatus();
				ticketStatus.setStatus(objArr[4].toString());
				ticketStatus.setStatusCode(objArr[5].toString());
				ticket.setTicketStatus(ticketStatus);
				final TicketPriority ticketPriority = new TicketPriority();
				ticketPriority.setPriority(objArr[6].toString());
				ticket.setTicketPriority(ticketPriority);
				final ProductCustomer productCustomer = new ProductCustomer();
				final Product product = new Product();
				product.setProductName(objArr[7].toString());
				productCustomer.setProduct(product);
				final User user = new User();
				user.setFullname(objArr[8].toString());
				productCustomer.setUser(user);
				ticket.setProductCustomer(productCustomer);
				tickets.add(ticket);
			});
		}
		return tickets;
	}

}
