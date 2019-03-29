package com.bafapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String type, amount;
	
	@ManyToMany(mappedBy = "product")
	private Set<Orders> order;

	public Products() {}
	
	public Products(long id, String type, String amount) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
