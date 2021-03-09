package com.sprint.ticketbookingsystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserTable")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	int id;
	String password;
	String role;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id")
	Customer cust;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "adminId")
	Admin admin;
	
	public User() {}

	public User(int id, String password, String role, Admin admin) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
		this.admin = admin;
	}

	public User(int id, String password, String role, Customer cust) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
		this.cust = cust;
	}

	public User(String password, String role, Customer cust) {
		super();
		this.password = password;
		this.role = role;
		this.cust = cust;
	}
	

	public User(int id, String password, Admin admin) {
		super();
		this.id = id;
		this.password = password;
		this.admin = admin;
	}
	

	public User(int id, String password, String role) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", role=" + role + ", cust=" + cust + "]";
	}

	

}
