package com.example.service;

import com.example.dao.StudentRepository;
import com.example.model.StudentEntity;
import com.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by test on 02.05.2017.
 */
@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(StudentEntity student) {
        studentRepository.save(student);
    }
}
