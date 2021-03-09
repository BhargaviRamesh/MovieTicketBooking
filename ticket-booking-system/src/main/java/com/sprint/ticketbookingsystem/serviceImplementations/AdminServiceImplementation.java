package com.sprint.ticketbookingsystem.serviceImplementations;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint.ticketbookingsystem.entities.Admin;
import com.sprint.ticketbookingsystem.repos.AdminRepository;
import com.sprint.ticketbookingsystem.services.IAdminService;

@Service
public class AdminServiceImplementation implements IAdminService {
	@Autowired
	AdminRepository iar;
	
	Optional<Admin> admins = null;
	
	//Adding a Admin
	public void addAdmin(Admin a)   {
		admins = iar.findById(a.getadminId());
		if(admins.isEmpty()) {
			iar.save(a);
		}
//		else {
//			 
//			 new AdminAlreadyExistsException("Admin with id:"+a.getadminId()+" already exists");
//		}
	}
	
	//Viewing all admins
	public List<Admin> viewAllAdmin() {
		List<Admin> admins = iar.findAll();
		return admins;
	}

	//Viewing customer by id
	public ResponseEntity<Admin> viewAdminById(int id) {
		ResponseEntity<Admin> re = null;
		Optional<Admin> admin = iar.findById(id);
		Admin a = null;
		if(admin.isPresent()) {
			a = admin.get();
			re = new ResponseEntity<>(a, HttpStatus.OK);
		}
		else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	//Deleting a customer
	public void deleteAdmin(int id){
		Optional<Admin> admin = iar.findById(id);
		Admin a = null;
		if(admin.isPresent()) {
			a = admin.get();
			iar.delete(a);
		}
//		else {
//			throw new CustomerDoesNotExistException("Customer with id:"+c.getCust_id()+" does not exist");
//		}
	}

	//Update
	@Transactional
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> getAdmin = iar.findById(admin.getadminId());
		Admin updateadmin = null;
		if(getAdmin.isPresent()) {
			updateadmin = getAdmin.get();
			if(admin.getadminName()!=null) {
				updateadmin.setadminName(admin.getadminName());
			}
			if(admin.getadminContact()!=null) {
				updateadmin.setadminContact(admin.getadminContact());
			}
			
		}
		return updateadmin;
	}


}
