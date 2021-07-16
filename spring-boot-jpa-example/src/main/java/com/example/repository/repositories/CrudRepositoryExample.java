package com.example.repository.repositories;

import com.example.repository.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Piyush Kumar.
 * @since 16/07/21.
 */
@Repository
public interface CrudRepositoryExample extends CrudRepository<Student, Integer> {
}
