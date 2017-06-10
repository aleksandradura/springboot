package com.example.dao;

import com.example.model.StudentEntity;
import com.example.model.Task;
import com.example.model.TeacherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by test on 31.05.2017.
 */
@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer>, PagingAndSortingRepository<TeacherEntity, Integer> {
    TeacherEntity findByLastName(String lastName);
    TeacherEntity findByTeacherId(int teacherId);
    //TeacherEntity findByKategoria(String Kategoria);
}
