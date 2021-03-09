package com.sprint.ticketbookingsystem.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ticketbookingsystem.entities.Customer;
import com.sprint.ticketbookingsystem.repos.ICustomerRepository;
import com.sprint.ticketbookingsystem.services.ICustomerService;



@RestController
public class ICustomerController {
	
	@Autowired
	ICustomerRepository icr;
	
	@Autowired
	ICustomerService ics;
	
	Optional<Customer> customers = null;

	//Adding a customer
	@PostMapping("/addCustomer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCustomer(@RequestBody Customer c) {
		ics.addCustomer(c);
	}
	
	//View all Customers
	@GetMapping("/getcutomers")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Customer> viewAllCustomer(){
		return ics.viewAllCustomer();
		
	}
	
	//View customer by id
	@GetMapping("/getcustomerid/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("id") int id) {
		return ics.viewCustomerById(id);
	}
	
	//Update customer 
	
	@PutMapping("/customers")
	@ResponseStatus(code = HttpStatus.OK)
	@Transactional
	public void updateCustomer(@RequestBody Customer c) {
		ics.updateCustomer(c);
	}
	
	//Deleting a customer by id
	@DeleteMapping("/deletecustomer/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteCustomer(@PathVariable("id") int id) {
		 ics.deleteCustomer(id);
	}
	

}
