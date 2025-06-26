package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Enitity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entiy manager using constructor system
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }






    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer theId) {
        return entityManager.find(Student.class, theId);
    }

    @Override
    public List<Student> findAll() {
        //create query
//        TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);

        //sort by last name ny default asc
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by lastName desc", Student.class);


        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);

        //return results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteById(Integer theId) {
        //retrieve the studenet
        Student theStudent = entityManager.find(Student.class,theId);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }
}
