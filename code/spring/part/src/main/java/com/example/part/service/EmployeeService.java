package com.example.part.service;

import com.example.part.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Object findById(int employeeId);
    void saveOrUpdate(Employee theEmployee);
    void deleteById(int employeeId);
}
