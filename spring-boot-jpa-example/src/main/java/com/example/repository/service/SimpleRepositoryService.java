package com.example.repository.service;

import com.example.repository.Student;
import com.example.repository.repositories.SimpleRepositoryExample;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 * @author Piyush Kumar.
 * @since 16/07/21.
 */
@Service
public class SimpleRepositoryService {

    @Autowired
    private SimpleRepositoryExample simpleRepositoryExample;

    public Student getById(int id) {
        return simpleRepositoryExample.findById(id);
    }

    public void save(Student student) {
        simpleRepositoryExample.save(student);
    }

    public List<Student> getByCollege(String name) {
        return simpleRepositoryExample.getByCollege(name);
    }

    public List<Student> findByNameStartingWith(String prefix) {
        return simpleRepositoryExample.findByNameStartingWith(prefix);
    }

    public List<Student> findByBio(String bio) {
        return simpleRepositoryExample.findByBio(bio);

    }

    public List<Student> findByCity(@Param("cityName") String city) {
        return simpleRepositoryExample.findByCity(city);
    }

    public Student findTheRecordWithName(String name) {
        return simpleRepositoryExample.findTheRecordWithName(name);
    }

    public List<Student> findTheRecordWithYourState(String state) {
        return simpleRepositoryExample.findTheRecordWithYourState(state);
    }


    public void updateRecordWithRecordId(int id, String updatedCity) {
        simpleRepositoryExample.updateHomeCityWithRecordId(id, updatedCity);

    }

}

