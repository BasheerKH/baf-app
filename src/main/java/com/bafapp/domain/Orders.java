package com.bafapp.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date date;
	private String note;
	
	@ManyToMany
	@JoinTable(
	  name = "order_prod", 
	  joinColumns = @JoinColumn(name = "order_id"), 
	  inverseJoinColumns = @JoinColumn(name = "prod_id"))
	private Set<Products> product;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    private Client client;
	
	@OneToOne(mappedBy = "orders")
    private Invoice invoice;

	public Orders() {}
	
	public Orders(Date date, String note, Client client) {
		super();
		this.date = date;
		this.note = note;
		this.client = client;
	}

	public Set<Products> getProduct() {
		return product;
	}

	public void setProduct(Set<Products> product) {
		this.product = product;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
