package com.redis.demo.redisdemo.service;

import com.redis.demo.redisdemo.beans.Employee;
import com.redis.demo.redisdemo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    // @Autowired annotation provides the automatic dependency injection.
    @Autowired
    EmployeeRepository employeeRepository;

    // Save Employee entity in the h2 database.
    public void save(final Employee Employee) {
        employeeRepository.save(Employee);
    }

    // Get all Employees from the h2 database.
    public List<Employee> getAllEmployees() {
        final List<Employee> Employees = new ArrayList<>();
        employeeRepository.findAll().forEach(Employee -> Employees.add(Employee));
        return Employees;
    }

    public void update(final Integer id, final Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not foud");
        }
        Employee employee = employeeOptional.get();
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmailAddress(updatedEmployee.getEmailAddress());
        employeeRepository.save(employee);
    }

    @Cacheable(value = "employee", key = "#id")
    public Employee getEmployee(Integer id) {
        log.info("Get Employee By Id: {}", id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not foud");
        }
        return employeeOptional.get();
    }

    // Get all Employees from the h2 database.
    public void deleteEmployee(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not foud");
        }
        employeeRepository.delete(employeeOptional.get());
    }
}