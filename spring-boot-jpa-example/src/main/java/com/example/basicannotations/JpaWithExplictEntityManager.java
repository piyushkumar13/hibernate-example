package com.example.basicannotations;

import static java.util.Arrays.asList;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaWithExplictEntityManager implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(JpaWithExplictEntityManager.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
//        entityManager.persist(new Student("Piyush","ABC College","New Delhi"));

        Subject subject1 = Subject.builder().subStream("Non Medical").name("Physics").subNumber("A100").build();
        Subject subject2 = Subject.builder().subStream("Non Medical").name("Chemistry").subNumber("A101").build();
        Subject subject3 = Subject.builder().subStream("Non Medical").name("Mathematics").subNumber("A102").build();

        Extra extra1 = Extra.builder().sports("Cricket").curricularTitles("Player of the Tournament").build();
        Extra extra2 = Extra.builder().sports("Basket Ball").curricularTitles("Player of the Tournament").build();
        Extra extra3 = Extra.builder().sports("Dance").curricularTitles("Mr Fresher").build();

        Student student = Student.builder()
                .name("Piyush")
                .college("ABC College")
                .homeAddress(Address.builder().buildingName("Sopara Buiding").city("Bengaluru").state("Karnataka").build())
                .officeAddress(Address.builder().buildingName("Dopara Buiding").city("Bengaluru").state("Karnataka").build())
                .dob(new Date(1990, 02, 13))
                .descriptionBio("This is Piyush Kumar.")
                .subjects(asList(subject1, subject2, subject3))
                .alias(asList("MJ", "Champ"))
                .extras(asList(extra1, extra2, extra3))
                .build();
        entityManager.persist(student);


        Student fetchedStudent = entityManager.find(Student.class, 1);

        System.out.println("Fetched student is ::: " + fetchedStudent);
    }
}