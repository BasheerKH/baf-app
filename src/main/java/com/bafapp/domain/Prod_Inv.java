package com.bafapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prod_Inv implements Serializable{
	
	private Invoice invoice;
	private Products products;
	private int price;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "invoice_Id")
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	@Id
    @ManyToOne
    @JoinColumn(name = "products_Id")
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	
	@Column(name = "price")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
