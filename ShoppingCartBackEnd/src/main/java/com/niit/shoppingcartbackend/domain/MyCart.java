package com.niit.shoppingcartbackend.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity
@Component
public class MyCart {
	
	@Id
	private String id;
	
	private String user_id;
	
	private String product_name;
	
	private double price;
	
	private char status;
	
	private Date date_added;
	
	private double quantity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char c) {
		this.status = c;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date) {
		this.date_added = date;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	

}
