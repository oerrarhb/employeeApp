package com.othmane.employeemanager.repository;

import com.othmane.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employee, Long> {

}
