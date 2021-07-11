package com.springboot.multimodular.controller;

import com.multimodular.api.EmployeeDto;
import com.springboot.multimodular.Service.EmployeeService;
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
