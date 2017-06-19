package com.example.dao;

import com.example.model.StudentEntity;
import com.example.model.Task;
import com.example.model.TeacherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by test on 02.05.2017.
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer>, PagingAndSortingRepository<StudentEntity, Integer> {
    StudentEntity findByIndeks(String indeks);
    StudentEntity findByLastName(String lastName);
    StudentEntity findById(int studentId);
    //StudentEntity findByKategoria(String kategoria);
}
