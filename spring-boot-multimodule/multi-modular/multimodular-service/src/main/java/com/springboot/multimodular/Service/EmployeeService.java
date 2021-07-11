package com.springboot.multimodular.Service;

import com.multimodular.api.EmployeeDto;
import com.springboot.multimodular.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto findById(Long id) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employeeRepository.findById(id).get().getId());
        return employeeDto;
    }
}
