package com.example.part.dao;

import com.example.part.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Object findById(int theId);
    void saveOrUpdate(Employee theEmployee);
    void deleteById(int theId);
}
