package com.sprint.ticketbookingsystem.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sprint.ticketbookingsystem.entities.User;
import com.sprint.ticketbookingsystem.serviceImplementations.UserService;



@Controller
public class IUserController {
	
	@Autowired
	UserService ius;
	
	@Autowired
	IUserController iuc;
	
	Optional<User> users = null;

	@PostMapping("/addUser")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addUser(@RequestBody User u) {
		ius.addUser(u);
	}
	
	public void signin() {}
	
	public void signup() {}
}
