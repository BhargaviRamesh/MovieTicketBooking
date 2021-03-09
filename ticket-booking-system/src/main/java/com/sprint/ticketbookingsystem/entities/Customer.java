package com.sprint.ticketbookingsystem.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	int cust_id;
	String cust_name;
	String address;
	String mobile_num;
	String email;
	String password;
	
	@OneToOne(mappedBy = "cust")
	User user;
	
//	@OneToMany(mappedBy="cust")
//	private List<TicketBooking> ticketBooking;
	
	public Customer() {}

	public Customer(int cust_id, String cust_name, String address, String mobile_num, String email, String password) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.address = address;
		this.mobile_num = mobile_num;
		this.email = email;
		this.password = password;
	}


	public int getCust_id() {
		return cust_id;
	}


	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}


	public String getCust_name() {
		return cust_name;
	}


	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobile_num() {
		return mobile_num;
	}


	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		Customer customer = null;
		return customer;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", address=" + address + ", mobile_num="
				+ mobile_num + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
