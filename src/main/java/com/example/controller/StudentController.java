package com.example.controller;

import com.example.dao.StudentRepository;
import com.example.dao.TaskRepository;
import com.example.dao.TeacherRepository;
import com.example.model.StudentEntity;
import com.example.service.UserService;
import com.example.service.TaskService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by test on 05.06.2017.
 */
@Controller
//@RequestMapping("user")
public class StudentController {

    private TeacherRepository teacherRepository;
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService studentService;
    @Autowired
    private TeacherService teacherService;
    private StudentEntity studentEntity;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {this.studentRepository = studentRepository;}


//    @RequestMapping(value = "/data-student", method = RequestMethod.GET)
//    public String d(HttpServletRequest request) {
//        request.setAttribute("tas", studentService.findAllS());
//        request.setAttribute("mode" , "MODE_DATASTUDENT");
//        return "studentHomePage";
//    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String startStudent() {
        return "startStudent";
    }

    @RequestMapping(value = "/student2", method = RequestMethod.GET)
    public String student() {
        return "studentHomePage";
    }

    @RequestMapping(value = "/loginStudent", method = RequestMethod.GET)
    public String loginStudent() {
        return "loginStudent";
    }

    @RequestMapping(value = "/registrationStudent", method = RequestMethod.GET)
    public String registrationStudent() {
        return "registrationStudent";
    }

    @RequestMapping(value = "/save-student", method = RequestMethod.POST)
    public String saveStudent(@Valid StudentEntity student, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "registrationStudent";
        }
        studentService.save(student);
        //request.setAttribute("tasks", studentService.findAll());
        //request.setAttribute("mode" , "MODE_ST");
        return "redirect:/";
    }
}
