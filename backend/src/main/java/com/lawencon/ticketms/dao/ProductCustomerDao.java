package com.lawencon.ticketms.dao;

import java.util.List;

import com.lawencon.ticketms.model.ProductCustomer;

public interface ProductCustomerDao extends BaseDao<ProductCustomer>{
	List<ProductCustomer> getAllIdCust(Long id);
}
