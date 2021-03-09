package com.sprint.ticketbookingsystem;

import java.util.List;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sprint.ticketbookingsystem.entities.Admin;
import com.sprint.ticketbookingsystem.services.IAdminService;
@Configurable
@SpringBootTest
public class AdminServiceTest {
	@Autowired
	IAdminService adminService;
	
//	@Test
	void testaddAdmin() {
		
		try {
			Admin admin = new Admin(1,"Chand","9899998805");
			adminService.addAdmin(admin);

		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	void testViewAdmin() {
		int id=1;
		ResponseEntity<Admin> admin = adminService.viewAdminById(id);
		System.out.println(admin);
	}
	
//	@Test
	void testViewAllAdmins() {
		List<Admin> admins = adminService.viewAllAdmin();
		System.out.println(admins);
	}
	
//	@Test
	void testRemoveAdmin() {
		int id=5;
		adminService.deleteAdmin(id);
		System.out.println("Admin Deleted!");
	}
	
//	@Test
	void testUpdateAdmin() {
		int id=3;
		Admin admin = new Admin(3,null,null);
		adminService.updateAdmin(admin);
	}
}
