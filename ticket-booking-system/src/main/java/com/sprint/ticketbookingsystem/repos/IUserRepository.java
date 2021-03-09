package com.sprint.ticketbookingsystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.ticketbookingsystem.entities.User;



public interface IUserRepository extends JpaRepository<User, Integer>{


}
