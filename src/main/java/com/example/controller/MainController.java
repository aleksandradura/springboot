package com.example.controller;

import com.example.model.StudentEntity;
import com.example.model.Task;
import com.example.service.StudentService;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by test on 01.05.2017.
 */
@Controller
public class MainController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String hello(HttpServletRequest request) {
        request.setAttribute("mode" , "MODE_HOME");
        return "index";
    }
    @RequestMapping(path = "/student", method = RequestMethod.GET)
    public String startStudent() {
        return "startStudent";
    }
    @RequestMapping(path = "/student2", method = RequestMethod.GET)
    public String student() {
        return "studentHomePage";
    }
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public String teacher() {
        return "teacherHomePage";
    }
    @RequestMapping(path = "/loginStudent", method = RequestMethod.GET)
    public String loginStudent() {
        return "loginStudent";
    }
    @RequestMapping(path = "/registrationStudent", method = RequestMethod.GET)
    public String registrationStudent() {
        return "registrationStudent";
    }
    @RequestMapping(path = "/save-student", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute StudentEntity student, BindingResult bindingResult, HttpServletRequest request) {

        studentService.save(student);
        //request.setAttribute("tasks", studentService.findAll());
        //request.setAttribute("mode" , "MODE_ST");
        return "startStudent";
    }

    @RequestMapping(path = "/all-tasks", method = RequestMethod.GET)
    public String allTasks(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode" , "MODE_TASKS");
        return "index";
    }
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String home(Model model) {
        List<Task> taski;
        taski = taskService.findAll();
        model.addAttribute("taski", taski);
        return "home";
    }
    @RequestMapping(path = "/new-task", method = RequestMethod.GET)
    public String newTask(HttpServletRequest request) {
        //request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode" , "MODE_NEW");
        return "index";
    }
    @RequestMapping(path = "/save-task", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {

        taskService.save(task);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode" , "MODE_TASKS");
        return "index";
    }
    @RequestMapping(path = "/update-task", method = RequestMethod.GET)
    public String updateTask(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findTask(id));
        request.setAttribute("mode" , "MODE_UPDATE");
        return "index";
    }
    @RequestMapping(path = "/delete-task", method = RequestMethod.GET)
    public String deleteTask(@RequestParam int id, HttpServletRequest request) {
        taskService.delete(id);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode" , "MODE_TASKS");
        return "index";
    }

//    @GetMapping("/save")
//    public String saveTask(@RequestParam String name, @RequestParam String desc) {
//        Task task = new Task(name, desc, false);
//        taskService.save(task);
//        return "Task saved";
//
//    }
//    @GetMapping("/delete")
//    public String saveTask(@RequestParam int id) {
//        taskService.delete(id);
//        return "Task deleted";
//
//    }
//    @RequestMapping(path = "/del", method = RequestMethod.GET)
//    public String delete(Model model, @RequestParam int id) {
//        //List<Task> taski;
//        taskService.delete(id);
//        model.addAttribute("taski", id);
//        return "delete";
//    }
}
