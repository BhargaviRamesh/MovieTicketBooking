package com.sprint.ticketbookingsystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sprint.ticketbookingsystem.entities.Admin;

@Component
public interface IAdminService {

	
	@Transactional
	public void addAdmin(Admin admin);
	public List<Admin> viewAllAdmin();
	public ResponseEntity<Admin> viewAdminById(int id);
	public void deleteAdmin(int id);
	public Admin updateAdmin(Admin a);

}
