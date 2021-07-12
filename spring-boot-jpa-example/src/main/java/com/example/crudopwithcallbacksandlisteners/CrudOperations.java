package com.example.crudopwithcallbacksandlisteners;

import static java.util.Arrays.asList;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 * @author Piyush Kumar.
 * @since 11/07/21.
 */

@Component
@Transactional
public class CrudOperations {

    @PersistenceContext
    private EntityManager entityManager;

    public void persistObject(){

        Student student = createStudentObject("Piyush", "This is Piyush Kumar.", "ABC College");

        entityManager.persist(student);

    }

    public void persistObject(Student student){

        entityManager.persist(student);
    }

    public Student findByID(int id) {

        return entityManager.find(Student.class, id);
    }


    public Student createStudentObject(String name, String descriptionBio, String college){

        Subject subject1 = Subject.builder().subStream("Non Medical").name("Physics").subNumber("A100").build();
        Subject subject2 = Subject.builder().subStream("Non Medical").name("Chemistry").subNumber("A101").build();
        Subject subject3 = Subject.builder().subStream("Non Medical").name("Mathematics").subNumber("A102").build();

        Extra extra1 = Extra.builder().sports("Cricket").curricularTitles("Player of the Tournament").build();
        Extra extra2 = Extra.builder().sports("Basket Ball").curricularTitles("Player of the Tournament").build();
        Extra extra3 = Extra.builder().sports("Dance").curricularTitles("Mr Fresher").build();

        Student student = Student.builder()
                .name(name)
                .college(college)
                .homeAddress(Address.builder().buildingName("Sopara Buiding").city("Bengaluru").state("Karnataka").build())
                .officeAddress(Address.builder().buildingName("Dopara Buiding").city("Bengaluru").state("Karnataka").build())
                .dob(new Date(1990, 02, 13))
                .descriptionBio(descriptionBio)
                .subjects(asList(subject1, subject2, subject3))
                .alias(asList("MJ", "Champ"))
                .extras(asList(extra1, extra2, extra3))
                .build();
        return student;

    }

    public void detachEntity(Student student){

        entityManager.detach(student);
    }

    public void deleteEntity(Student student){
        entityManager.remove(student);
    }
}
