package com.springboot.multimodular2.controller;

import com.springboot.multimodular2.Service.EmployeeService;
import com.springboot.multimodular2.dto.EmployeeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping()
    public EmployeeDto findById(Long id) {
        return employeeService.findById(id);
    }
}
