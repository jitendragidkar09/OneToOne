package com.example.OneToOne.controller;

import com.example.OneToOne.entity.Employee;
import com.example.OneToOne.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_XML_VALUE)
    public Employee getEmployeeById(@PathVariable Integer employeeId){
        Optional<Employee> employee = employeeService.findEmployeeById(employeeId);
        Employee employee1 = employee.orElseThrow(() -> new RuntimeException("User with given id is not found"));
        return employee1;
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId){
        employeeService.removeEmployeeById(employeeId);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(employee);
        return employee1;
    }
}
