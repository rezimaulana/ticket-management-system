package com.lawencon.ticketms.dao.impl.hibernate.springdatanativequery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
abstract class BaseDaoImpl {
	@PersistenceContext
	protected EntityManager em;

	public void setEm(@Autowired EntityManager em) {
		this.em = em;
	}
}
