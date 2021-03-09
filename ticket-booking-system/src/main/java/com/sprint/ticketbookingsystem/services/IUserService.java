package com.sprint.ticketbookingsystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint.ticketbookingsystem.entities.User;
@Service
public interface IUserService {

	
	@Transactional
	public void addUser(User user);
	public List<User> viewAllUser();
	public ResponseEntity<User> viewUserById(int id);
	public void deleteUser(int id);
	public User updateUser(User u);


}
