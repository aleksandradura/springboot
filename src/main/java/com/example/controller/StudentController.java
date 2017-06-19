package com.example.controller;

import com.example.dao.StudentRepository;
import com.example.dao.TaskRepository;
import com.example.dao.TeacherRepository;
import com.example.model.KategoriaEntity;
import com.example.model.ObecnoscEntity;
import com.example.model.StudentEntity;
import com.example.model.Task;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by test on 05.06.2017.
 */
@Controller
public class StudentController {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TaskService taskService;
    @Autowired
    private ObecnoscService obecnoscService;
    @Autowired
    private UserService studentService;
    @Autowired
    private KategoriaService kategoriaService;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginStudent() {
        return "login";
    }

    @RequestMapping(path = "/show-message", method = RequestMethod.GET)
    public String showMessage(Model model) {
        List<Task> taski;
        taski = taskService.findAll(new PageRequest(2, 1));
        model.addAttribute("taski", taski);
        return "showMessage";
    }
    @RequestMapping(path = "/show-presence", method = RequestMethod.GET)
    public String showPresence(Model model) {
        List<ObecnoscEntity> obecnosci;
        obecnosci = obecnoscService.findAllPresence(new PageRequest(2, 1));
        model.addAttribute("obecnosci", obecnosci);
        return "showPresence";
    }
    @RequestMapping(path = "/enroll-lessons", method = RequestMethod.GET)
    public String enroll(Model model) {
        List<KategoriaEntity> categories;
        categories = kategoriaService.findAllCategories(new PageRequest(2, 1));
        model.addAttribute("categories", categories);
        return "enroll";
    }
    @RequestMapping(path = "/save-lessons", method = RequestMethod.POST)
    public String saveStatus(@ModelAttribute KategoriaEntity kategoria, ModelAndView model, BindingResult bindingResult, HttpServletRequest request) {
        model.addObject("kategoria", kategoria);

//  request.setAttribute("mode" , "MODE_STATUS");
        return "studentHomePage";
    }

    @RequestMapping(value = "/registrationStudent", method = RequestMethod.GET)
    public String registrationStudent() {
        return "registrationStudent";
    }

    @RequestMapping(value = "/save-student", method = RequestMethod.POST)
    public String saveStudent(@Valid @ModelAttribute("userForm") StudentEntity student, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "registrationStudent";
        }
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentService.save(student);
        //request.setAttribute("tasks", studentService.findAll());
        //request.setAttribute("mode" , "MODE_ST");
        return "redirect:/";
    }
//        @RequestMapping(path = "/logout")
//    public String logout(HttpServletRequest request) {
// //       request.setAttribute("tasks", taskService.findAll(new PageRequest(2, 1)));
// //       request.setAttribute("mode" , "MODE_TASKS");
//        return "redirect:/";
//    }
}
