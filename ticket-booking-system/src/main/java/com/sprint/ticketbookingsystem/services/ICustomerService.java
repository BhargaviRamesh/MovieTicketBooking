package com.sprint.ticketbookingsystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sprint.ticketbookingsystem.entities.Customer;


@Component
public interface ICustomerService {
	public void addCustomer(Customer cust);
	
	@Transactional
	public List<Customer> viewAllCustomer();
	public ResponseEntity<Customer> viewCustomerById(int id);
	public void deleteCustomer(int id);
	public Customer updateCustomer(Customer c);

}
