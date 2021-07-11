package com.springboot.multimodular.repository;

import com.springboot.multimodular.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
