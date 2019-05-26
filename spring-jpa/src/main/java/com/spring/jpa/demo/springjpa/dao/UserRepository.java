package com.spring.jpa.demo.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.demo.springjpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
