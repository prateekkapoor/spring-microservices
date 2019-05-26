package com.spring.jpa.demo.springjpa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.jpa.demo.springjpa.dao.UserRepository;
import com.spring.jpa.demo.springjpa.entity.User;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("New User is created: " + user);
		
		User retrievedUser=userRepository.findById(1L).get();
		log.info("Retrieved user: "+retrievedUser);
		
		List<User> allUsers = userRepository.findAll();
		log.info("All users: "+allUsers);
	}
}
