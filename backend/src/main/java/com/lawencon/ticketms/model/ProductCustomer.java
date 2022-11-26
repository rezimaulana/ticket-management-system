package com.lawencon.ticketms.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products_cust")
public class ProductCustomer extends BaseModel{
	@ManyToOne
	@JoinColumn(name = "product_id", nullable=false)
	private Product product;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable=false)
	private User user;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(final Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(final User user) {
		this.user = user;
	}
}
