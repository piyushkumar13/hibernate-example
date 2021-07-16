package com.example.repository.service;

import com.example.repository.Student;
import com.example.repository.repositories.CrudRepositoryExample;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Piyush Kumar.
 * @since 16/07/21.
 */

@Service
public class CrudService {

    @Autowired
    private CrudRepositoryExample crudRepositoryExample;

    public void saveEntity(Student student) {
        crudRepositoryExample.save(student);
    }

    public void saveEntities(List<Student> students) {
        crudRepositoryExample.saveAll(students);
    }

}
