package com.example.service;

import com.example.dao.StudentRepository;
import com.example.model.ObecnoscEntity;
import com.example.model.StudentEntity;
import com.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 02.05.2017.
 */
@Service
@Transactional
public class UserService {
    private static final int PAGE_SIZE = 3;

    private final StudentRepository studentRepository;

    public UserService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(StudentEntity student) {
        studentRepository.save(student);
    }
    public StudentEntity findStudent(String indeks) {
        return studentRepository.findByIndeks(indeks);
    }
    public List<StudentEntity> findAllS(PageRequest pageRequest){
        List<StudentEntity> tas = new ArrayList<>();
        for(StudentEntity student : studentRepository.findAll()) {
            tas.add(student);
        }
        return tas;
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }

    public Page<StudentEntity> getStudentLog(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return studentRepository.findAll(request);
    }
}
