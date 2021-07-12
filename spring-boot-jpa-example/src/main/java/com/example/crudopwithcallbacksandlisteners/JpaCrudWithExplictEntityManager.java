package com.example.crudopwithcallbacksandlisteners;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaCrudWithExplictEntityManager implements ApplicationRunner {

    @Autowired
    private CrudOperations crudOperations;

    public static void main(String[] args) {
        SpringApplication.run(JpaCrudWithExplictEntityManager.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        /* Create operation */
        crudOperations.persistObject();

        /* Read operation */
        Student fetchedStudent = crudOperations.findByID(1);
        System.out.println("Fetched student is ::: " + fetchedStudent);

        /* Update Operation */
        fetchedStudent.setDescriptionBio("This is Piyush Kumar, Computer Science Engineer.");

        /* Update Non-persistent object */
        Student student = crudOperations.createStudentObject("Name-1",
                "I am also computer science Engineer",
                "ABC College");
        crudOperations.persistObject(student); // At this stage student object will become persistent object.
        student.setName("Name-2");

        /* Delete operation */

        crudOperations.deleteEntity(student);
    }
}