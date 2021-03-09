package com.sprint.ticketbookingsystem.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.sprint.ticketbookingsystem.entities.Customer;



public interface ICustomerRepository extends JpaRepository<Customer, Integer>{


}
