package com.sprint.ticketbookingsystem;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.ticketbookingsystem.entities.User;
import com.sprint.ticketbookingsystem.services.IUserService;
@Configurable
@SpringBootTest
public class UserServiceTest {
	@Autowired
	IUserService userService;
	
	@Test
	void testaddUser() {
		
		try {
			User us = new User(1,"root","admin");
			userService.addUser(us);

		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
}
