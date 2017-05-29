package com.example.dao;

import com.example.model.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by test on 02.05.2017.
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, String> {
    StudentEntity findByUsername(String studentname);
}
