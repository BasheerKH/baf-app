package com.bafapp.domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date date;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice")
    private Invoice invoice;

	public Payment() {}
	
	public Payment(Date date, String name, Invoice invoice) {
		super();
		this.date = date;
		this.name = name;
		this.invoice = invoice;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
