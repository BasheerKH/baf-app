package com.bafapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Orders orders;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="invoice")
    private List<Payment> payment;
	
	public Invoice(){}

	public Invoice(String description, Orders orders, List<Payment> payment) {
		super();
		this.description = description;
		this.orders = orders;
		this.payment = payment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	

}
