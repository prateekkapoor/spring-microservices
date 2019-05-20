package com.demo.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.microservices.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangevalueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
