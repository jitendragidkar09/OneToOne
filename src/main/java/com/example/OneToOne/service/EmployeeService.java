package com.example.OneToOne.service;

import com.example.OneToOne.entity.Employee;
import com.example.OneToOne.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(Integer employeeId){
        return employeeRepository.findById(employeeId);
    }

    public void removeEmployeeById(Integer employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(Employee employee){
        Integer employeeId = employee.getEmployeeId();
        Employee oldEmployee = employeeRepository.findById(employeeId).get();
        oldEmployee.setEmployeeName(employee.getEmployeeName());
        oldEmployee.setAddress(employee.getAddress());
        Employee employee1 = employeeRepository.save(oldEmployee);
        return employee1;
    }
}
