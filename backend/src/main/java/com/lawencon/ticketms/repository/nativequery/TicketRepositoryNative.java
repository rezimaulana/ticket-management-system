package com.lawencon.ticketms.repository.nativequery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.Ticket;

@Repository
public interface TicketRepositoryNative extends JpaRepository<Ticket, Long>{
	int removeById(Long id);
	@Query(value= "SELECT t.id AS t_id, t.code AS t_code, t.title AS t_title, t.content AS t_content, "
				+ "ts.status AS ts_status, ts.status_code AS ts_code, tp.priority AS tp_priority, p.product_name AS p_name, "
				+ "t.ver AS t_ver "
				+ "FROM tickets t "
				+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
				+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
				+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
				+ "INNER JOIN products p ON pc.product_id = p.id "
				+ "WHERE pc.customer_id = :id", nativeQuery=true)
	List <Object[]> getAllIdCust(@Param("id") Long id);
	@Query(value="SELECT t.id AS t_id, t.code AS t_code, t.title AS t_title, t.content AS t_content, "
				+ "ts.status AS ts_status, ts.status_code AS ts_code, tp.priority AS tp_priority, "
				+ "p.product_name AS p_name, u.fullname AS u_fullname, t.ver AS t_ver "
				+ "FROM tickets t "
				+ "INNER JOIN tickets_priority tp ON t.ticket_priority_id = tp.id "
				+ "INNER JOIN tickets_status ts ON t.ticket_status_id = ts.id "
				+ "INNER JOIN products_cust pc ON t.product_cust_id = pc.id "
				+ "INNER JOIN products p ON pc.product_id = p.id "
				+ "INNER JOIN users u ON u.id = pc.customer_id "
				+ "WHERE u.pic_id = :id", nativeQuery=true)
	List <Object[]> getAllIdPic(@Param("id") Long id);
}
