package com.example.service;

import com.example.dao.TeacherRepository;
import com.example.model.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by test on 31.05.2017.
 */
@Service
@Transactional
public class TeacherService {
    private static final int PAGE_SIZE = 3;


    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

//    public TeacherEntity findTeacher(String lastName) {
//        return teacherRepository.findOne(lastName);
//    }
    public TeacherEntity findByTeacherId(int teacherId) {
        return teacherRepository.findById(teacherId);

    }

    public Page<TeacherEntity> getTeacherLog(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return teacherRepository.findAll(request);
    }


//    public Page<TeacherEntity> requestPage(Predicate predicate, Pageable pageRequest) {
//        return teacherRepository.findAll(predicate, pageRequest);
//    }
//
//    public Page<TeacherEntity> requestPage(Pageable pageRequest) {
//        return teacherRepository.findAll(pageRequest);
//    }

}
