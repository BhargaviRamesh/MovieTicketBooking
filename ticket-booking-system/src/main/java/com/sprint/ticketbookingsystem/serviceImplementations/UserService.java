package com.sprint.ticketbookingsystem.serviceImplementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sprint.ticketbookingsystem.entities.User;
import com.sprint.ticketbookingsystem.repos.IUserRepository;


@SpringBootApplication
public class UserService {

	@Autowired
	IUserRepository iur;
	
	Optional<User> users = null;

	public void addUser(User u) {
		users = iur.findById(u.getId());
		if(users.isEmpty()) {
			iur.save(u);
		}
		
	}

}
