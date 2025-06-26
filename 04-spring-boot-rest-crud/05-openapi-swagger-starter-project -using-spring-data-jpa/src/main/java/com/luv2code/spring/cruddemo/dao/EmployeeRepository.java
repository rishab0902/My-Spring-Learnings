package com.luv2code.spring.cruddemo.dao;

import com.luv2code.spring.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
