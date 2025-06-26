package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Enitity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer theId);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student theStudent);
    void deleteById(Integer theId);
    int deleteAll();
}
