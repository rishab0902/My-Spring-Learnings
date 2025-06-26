package com.luv2code.cruddemo;

import com.luv2code.cruddemo.Enitity.Student;
import com.luv2code.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }


    //	@Bean
//	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
//		return runner->{
//			createStudent(studentDAO);
//		};
//	}
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudent(studentDAO);
//            queryForStudentByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudent(studentDAO);
        };


    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students .....");
        int numRoesDeleted = studentDAO.deleteAll();
        System.out.println("Deleted " + numRoesDeleted + " students");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.deleteById(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrieve the student based on the id:primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student theStudent = studentDAO.findById(studentId);


        //change the first name to "Scooby"
        System.out.println("Changing student's first name");
        theStudent.setFirstName("Scooby");

        //update the student
        studentDAO.update(theStudent);

        //display the uodated studenet
        System.out.println("Updated student: " + theStudent);
    }

    private void queryForStudentByLastName(StudentDAO studentDAO) {
        //get list of students
        List<Student> theStudents = studentDAO.findByLastName("Duck");

        //display list of students
        for (Student theStudent : theStudents) {
            System.out.println(theStudent);
        }
    }

    private void queryForStudent(StudentDAO studentDAO) {
        //get a list of studente
        List<Student> students = studentDAO.findAll();

        //diplay list of studennt
        for (Student theStudent : students) {
            System.out.println(theStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {
        //create a student object
        System.out.println("Creating a student object");
        Student theStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");


        //sve the object
        System.out.println("Saving the student");
        studentDAO.save(theStudent);


        //display the id of student
        int theId = theStudent.getId();
        System.out.println("Student saved with id: " + theId);

        //retrieve student based on id:primary key
        System.out.println("Retrieving student with id: " + theId);
        studentDAO.findById(theId);

        //display student
        System.out.println("Found student: " + theStudent);

    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        //create multiple students
        System.out.println("Creating 3 student objects ......");
        Student tempStudent = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Robert", "Taylor", "robert@luv2code.com");


        //save the students
        System.out.println("Saving the students .....");
        studentDAO.save(tempStudent);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        System.out.println("Done!");


    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object ......");
        Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");


        //save the student object
        System.out.println("Saving the student .....");
        studentDAO.save(tempStudent);


        //display id of the saved
        System.out.println("Saved student.Generated id: " + tempStudent.getId());


    }


}
