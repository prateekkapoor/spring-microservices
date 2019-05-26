package com.spring.jpa.demo.springjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.jpa.demo.springjpa.entity.User;

@Repository
@Transactional
public class UserDao {
@PersistenceContext
private EntityManager entityManager;
public Long saveUser(User user) {
	entityManager.persist(user);
	return user.getId();
}
}
