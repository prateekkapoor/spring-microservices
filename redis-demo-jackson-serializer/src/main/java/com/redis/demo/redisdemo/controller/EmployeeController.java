package com.redis.demo.redisdemo.controller;

import com.redis.demo.redisdemo.beans.Employee;
import com.redis.demo.redisdemo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/employees")
@Slf4j
// Useful to create the RESTful webservices.
public class EmployeeController {

    // @Autowired annotation provides the automatic dependency injection.
    @Autowired
    EmployeeService employeeService;

    // Save employee entity in the h2 database.
    // @PostMapping annotation handles the http post request matched with the given uri.
    // @RequestBody annotation binds the http request body to the domain object.
    // @Valid annotation validates a model after binding the user input to it.
    @PostMapping()
    public Employee save(final @RequestBody Employee employee) {
        log.info("Saving employee details in the database.");
        employeeService.save(employee);
        return employeeService.getEmployee(employee.getId());
    }

    @PutMapping(value = "/{id}")
    public Employee save(final @PathVariable("id") Integer id, final @RequestBody Employee employee) {
        log.info("Saving employee details in the database.");
        employeeService.update(id, employee);
        return employeeService.getEmployee(employee.getId());
    }

    // Get all Employees from the h2 database.
    // @GetMapping annotation handles the http get request matched with the given uri.
    @GetMapping()
    public List<Employee> getAllEmployees() {
        log.info("Getting Employee details from the database.");
        return employeeService.getAllEmployees();
    }

    // Get all Employees from the h2 database.
    // @GetMapping annotation handles the http get request matched with the given uri.
    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        log.info("Getting Employee details from the database.");
        return employeeService.getEmployee(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteEmployee(@PathVariable("id") Integer id) {
        log.info("Getting Employee details from the database.");
        employeeService.deleteEmployee(id);
    }
}