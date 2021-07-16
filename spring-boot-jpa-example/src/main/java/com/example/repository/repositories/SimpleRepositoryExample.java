package com.example.repository.repositories;

import com.example.repository.Student;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Piyush Kumar.
 * @since 16/07/21.
 */
@org.springframework.stereotype.Repository
public interface SimpleRepositoryExample extends Repository<Student, Integer> {

    void save(Student student);

    Student findById(int id);

    List<Student> getByCollege(String name);

    List<Student> findByNameStartingWith(String prefix);

    @Query("select s from STUDENT s where s.descriptionBio = ?1")
    List<Student> findByBio(String bio);

    @Query("select s from STUDENT s where s.homeAddress.city = :cityName")
    List<Student> findByCity(@Param("cityName") String city);

    @Query(value = "select * from STUDENT where STUDENT.name = ?1", nativeQuery = true)
    Student findTheRecordWithName(String name);

    List<Student> findTheRecordWithYourState(String state);

    @Transactional
    @Modifying
    @Query("update STUDENT s set s.homeAddress.city = :homeCityName where s.id = :id")
    void updateHomeCityWithRecordId(@Param("id") int id, @Param("homeCityName") String cityName);
}

