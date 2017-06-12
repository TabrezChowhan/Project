package com.niit.shoppingcartbackend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//import org.hibernate.annotations.Entity;

import org.springframework.stereotype.Component;

@Entity   // to map the database table
//@Table(name="user")   //if the table name and domain class name is different
@Component  //context.scan("com.niit")
public class User {
	
	@Id
	private String id;
	private String name;
	
	//@Min(5)
	//@Max(15)
	private String password;
	private String role;
	private String contact;
	
	
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
