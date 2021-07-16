package com.example.repository;

import static java.util.Arrays.asList;

import com.example.repository.service.CrudService;
import com.example.repository.service.SimpleRepositoryService;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Query Creation
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation  */
@SpringBootApplication
public class JpaRepositoriesApplication implements ApplicationRunner {

    @Autowired
    private CrudService crudService;

    @Autowired
    private SimpleRepositoryService simpleRepositoryService;

    public static void main(String[] args) {
        SpringApplication.run(JpaRepositoriesApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Student student1 = createStudentObject("Piyush", "This is Piyush Kumar", "ABC College");

        crudService.saveEntity(student1);

        Student student2 = createStudentObject("Vikas", "This is Vikas Kumar", "ABC College");
        crudService.saveEntity(student2);

        Student student3 = createStudentObject("Anand", "This is Anand Kumar", "ABC College");
        Student student4 = createStudentObject("Nilesh", "This is Nilesh Kumar", "ABC College");
        Student student5 = createStudentObject("Nitin", "This is Nitin Kumar", "ABC College");
        Student student6 = createStudentObject("Himanshu", "This is Himanshu Kumar", "ABC College");
        crudService.saveEntities(asList(student3, student4, student5, student6));

        Student s = simpleRepositoryService.getById(2);
        System.out.println("Fetched Student is ::: " + s);

        Student student7 = createStudentObject("Rahul", "This is Rahul Kumar", "ABC College");
        simpleRepositoryService.save(student7);

        List<Student> studentsByCollege = simpleRepositoryService.getByCollege("ABC College");

        System.out.println("Students fetched by college ::: ");

        studentsByCollege.forEach(System.out::println);


        List<Student> studentsByStarting = simpleRepositoryService.findByNameStartingWith("Ni");

        System.out.println("Students fetched by Prefix ::: ");

        studentsByStarting.forEach(System.out::println);


        List<Student> studentByBio = simpleRepositoryService.findByBio("This is Anand Kumar");
        System.out.println("Students fetched by Bio ::: ");
        studentByBio.forEach(System.out::println);

        List<Student> studentByCity = simpleRepositoryService.findByCity("Bengaluru");
        System.out.println("Students fetched by City ::: ");
        studentByCity.forEach(System.out::println);

        System.out.println("The record with name ::: " + simpleRepositoryService.findTheRecordWithName("Piyush"));

        List<Student> studentsByState = simpleRepositoryService.findTheRecordWithYourState("Karnataka");
        System.out.println("Students fetched by State ::: ");
        studentsByState.forEach(System.out::println);

        simpleRepositoryService.updateRecordWithRecordId(2, "New Delhi");

    }

    public Student createStudentObject(String name, String descriptionBio, String college) {

        Subject subject1 = Subject.builder().subStream("Non Medical").name("Physics").subNumber("A100").build();
        Subject subject2 = Subject.builder().subStream("Non Medical").name("Chemistry").subNumber("A101").build();
        Subject subject3 = Subject.builder().subStream("Non Medical").name("Mathematics").subNumber("A102").build();

        Extra extra1 = Extra.builder().sports("Cricket").curricularTitles("Player of the Tournament").build();
        Extra extra2 = Extra.builder().sports("Basket Ball").curricularTitles("Player of the Tournament").build();
        Extra extra3 = Extra.builder().sports("Dance").curricularTitles("Mr Fresher").build();

        Student student = Student.builder()
                .name(name)
                .college(college)
                .homeAddress(Address.builder().buildingName("Sopara Building").city("Bengaluru").state("Karnataka").build())
                .officeAddress(Address.builder().buildingName("Dopara Building").city("Bengaluru").state("Karnataka").build())
                .dob(new Date(1990, 02, 13))
                .descriptionBio(descriptionBio)
                .subjects(new HashSet<>(asList(subject1, subject2, subject3)))
                .alias(new HashSet<>(asList("MJ", "Champ")))
                .extras(new HashSet<>(asList(extra1, extra2, extra3)))
                .build();
        return student;

    }

}