package com.othmane.employeemanager.service;

import com.othmane.employeemanager.exception.UserNotFoundException;
import com.othmane.employeemanager.model.Employee;
import com.othmane.employeemanager.repository.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeRepo employeRepo;

    @Autowired
    public EmployeeService(EmployeRepo employeRepo) {
        this.employeRepo = employeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
        return employeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("The user is not found"));
    }
}
