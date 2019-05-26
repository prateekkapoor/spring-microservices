package com.spring.jpa.demo.springjpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.jpa.demo.springjpa.dao.UserDao;
import com.spring.jpa.demo.springjpa.entity.User;
@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{
@Autowired
private UserDao userDao;

private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		Long userId = userDao.saveUser(user);
		log.info("New User is created: "+userId);
	}
}
