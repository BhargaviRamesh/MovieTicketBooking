package com.sprint.ticketbookingsystem;

import java.util.List;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.sprint.ticketbookingsystem.entities.Customer;
import com.sprint.ticketbookingsystem.services.ICustomerService;

public class CustomerServiceTest {
	@Autowired
	ICustomerService customerService;
	
//	@Test
	void testAddMovie() {
		
//		Customer cust = new Customer(3, "Sam", "Delhi", "9884736323", "Sam@gmail.com", "hsgkdjddn");
//		customerService.addCustomer(cust);
//		System.out.println("Customer added");
		
		try {
			Customer cust = new Customer(3, "Sam", "Delhi", "9884736323", "Sam@gmail.com", "hsgkdjddn");
			customerService.addCustomer(cust);

		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	void testViewCustomers() {
		int id=1;
		ResponseEntity<Customer> cust = customerService.viewCustomerById(id);
		System.out.println(cust);
	}
	
//	@Test
	void testViewAllCustomers() {
		List<Customer> customers = customerService.viewAllCustomer();
		System.out.println(customers);
	}
	
//	@Test
	void testRemoveCustomer() {
		int id=5;
		customerService.deleteCustomer(id);
		System.out.println("Customer Deleted!");
	}
	
//	@Test
	void testUpdateCustomer() {
		int id=3;
		Customer cust = new Customer(3,null,null,null,null,"Password@123");
		customerService.updateCustomer(cust);
	}
}
