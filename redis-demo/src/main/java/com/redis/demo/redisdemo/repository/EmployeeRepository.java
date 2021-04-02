package com.redis.demo.redisdemo.repository;

import com.redis.demo.redisdemo.beans.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
 