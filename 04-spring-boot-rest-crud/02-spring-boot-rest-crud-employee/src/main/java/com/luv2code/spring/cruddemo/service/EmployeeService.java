package com.luv2code.spring.cruddemo.service;

import java.util.List;

import com.luv2code.spring.cruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
