package com.sprint.ticketbookingsystem.serviceImplementations;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import com.sprint.ticketbookingsystem.entities.Customer;
import com.sprint.ticketbookingsystem.exceptionhandling.CustomerAlreadyExistsException;
import com.sprint.ticketbookingsystem.repos.ICustomerRepository;
import com.sprint.ticketbookingsystem.services.ICustomerService;



@Service
public class CustomerServiceImplementation implements ICustomerService{
	@Autowired
	ICustomerRepository icr;
	
	Optional<Customer> customers = null;
	
	//Adding a customer
	public void addCustomer(Customer c)   {
		customers = icr.findById(c.getCust_id());
		if(customers.isEmpty()) {
			icr.save(c);
		}
		else {
			 
			 new CustomerAlreadyExistsException("Customer with id:"+c.getCust_id()+" already exists");
		}
	}
	
	//Viewing all customers
	public List<Customer> viewAllCustomer() {
		List<Customer> customers = icr.findAll();
		return customers;
	}

	//Viewing customer by id
	public ResponseEntity<Customer> viewCustomerById(int id) {
		ResponseEntity<Customer> re = null;
		Optional<Customer> customer = icr.findById(id);
		Customer c = null;
		if(customer.isPresent()) {
			c = customer.get();
			re = new ResponseEntity<>(c, HttpStatus.OK);
		}
		else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	//Deleting a customer
	public void deleteCustomer(int id){
		Optional<Customer> customer = icr.findById(id);
		Customer c = null;
		if(customer.isPresent()) {
			c = customer.get();
			icr.delete(c);
		}
//		else {
//			throw new CustomerDoesNotExistException("Customer with id:"+c.getCust_id()+" does not exist");
//		}
	}

	//Update
	@Transactional
	public Customer updateCustomer(Customer cust) {
		Optional<Customer> getCustomer = icr.findById(cust.getCust_id());
		Customer updatecust = null;
		if(getCustomer.isPresent()) {
			updatecust = getCustomer.get();
			if(cust.getCust_name()!=null) {
				updatecust.setCust_name(cust.getCust_name());
			}
			if(cust.getAddress()!=null) {
				updatecust.setAddress(cust.getAddress());
			}
			if(cust.getEmail()!=null) {
				updatecust.setEmail(cust.getEmail());
			}
			if(cust.getMobile_num()!=null) {
				updatecust.setMobile_num(cust.getMobile_num());
			}
			if(cust.getPassword()!=null) {
				updatecust.setPassword(cust.getPassword());
			}
		}
		return updatecust;
	}
}
