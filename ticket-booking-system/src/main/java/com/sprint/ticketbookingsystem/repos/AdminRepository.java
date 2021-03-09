package com.sprint.ticketbookingsystem.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sprint.ticketbookingsystem.entities.Admin;

@Repository

public interface AdminRepository extends JpaRepository<Admin,Integer> {
	//Service methods declaration
//	public Admin findByadminName(String adminName);
//	public Optional<Admin> findByadminId(int adminId);
	public Admin findByAdminNameAndAdminContact(String adminName, String adminContact);
}
