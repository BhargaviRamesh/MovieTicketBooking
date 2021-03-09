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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.sprint.ticketbookingsystem.entities.Admin;
import com.sprint.ticketbookingsystem.entities.Customer;
import com.sprint.ticketbookingsystem.repos.AdminRepository;
import com.sprint.ticketbookingsystem.services.IAdminService;
@RestController

public class IAdminController {
	
		@Autowired
		AdminRepository adminRepository;
		
		@Autowired
		IAdminService ad;
		
		//adding a new admin
		@PostMapping("/addadmin")
		@ResponseStatus(code = HttpStatus.CREATED)
		public void addAdmin(@RequestBody Admin a) {
			ad.addAdmin(a);
		}
		

    //Viewing all the admins		
		@GetMapping("/admins")
		public List<Admin> findAllAdmins(){
			return adminRepository.findAll();
		}
	
		//Update admin 
		
		@PutMapping("/admins")
		@ResponseStatus(code = HttpStatus.OK)
		@Transactional
		public void updateAdmin(@RequestBody Admin a) {
			ad.updateAdmin(a);
		}
		
		//View admin by id
		@GetMapping("/admin/{id}")
		@ResponseStatus(value = HttpStatus.OK)
		public ResponseEntity<Admin> viewAdminById(@PathVariable("id") int id) {
			return ad.viewAdminById(id);
		}
		
		
		
		@GetMapping("/admins/{adminName}/{adminContact}")
		public Admin findAdminByAdminNameAndAdminContact(@PathVariable("adminName") String adminName , @PathVariable("adminContact") String adminContact){
		 Admin a = adminRepository.findByAdminNameAndAdminContact(adminName, adminContact);
		 return a;
		}
		
		
		//Deleting a admin by id
		@DeleteMapping("/deleteadmin/{id}")
		@ResponseStatus(value = HttpStatus.OK)
		public void deleteAdmin(@PathVariable("id") int id) {
			 ad.deleteAdmin(id);
		}



}
