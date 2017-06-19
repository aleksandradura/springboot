package com.example.controller;

import com.example.dao.ImageRepository;
import com.example.dao.TaskRepository;
import com.example.dao.TeacherRepository;
import com.example.model.ImageEntity;
import com.example.model.Task;
import com.example.service.UserService;
import com.example.service.TaskService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

/**
 * Created by test on 01.05.2017.
 */
@Controller
public class MainController {

    private TeacherRepository teacherRepository;
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    public MainController(TeacherRepository teacherRepository) {this.teacherRepository = teacherRepository;}

    @Autowired
    private ImageRepository imageRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, Model model) {
        request.setAttribute("mode" , "MODE_HOME");
        Iterable<ImageEntity> images = imageRepository.findAll();
        model.addAttribute("images", images);

        for(ImageEntity imageEntity : images) {
            imageEntity.setData("data:image/jpeg;base64," + imageEntity.getData());
        }
        return "index";
    }
//    @RequestMapping(path = "/upload", method = RequestMethod.GET)
//    public String image() {
//        return "upload";
//    }



//    @RequestMapping(path = "/all-tasks", method = RequestMethod.GET)
//    public String allTasks(HttpServletRequest request) {
//        request.setAttribute("tasks", taskService.findAll(new PageRequest(2, 1)));
//        request.setAttribute("mode" , "MODE_TASKS");
//        return "index";
//    }
    @RequestMapping(path = "/new-task", method = RequestMethod.GET)
    public String newTask(HttpServletRequest request) {
        //request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode" , "MODE_NEW");
        return "index";
    }
    @RequestMapping(path = "/save-task", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {

        taskService.save(task);
        request.setAttribute("tasks", taskService.findAll(new PageRequest(2, 1)));
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
        request.setAttribute("tasks", taskService.findAll(new PageRequest(2, 1)));
        request.setAttribute("mode" , "MODE_TASKS");
        return "index";
    }

//    @RequestMapping(path = "/logout")
//    public String logout(HttpServletRequest request) {
//        request.setAttribute("tasks", taskService.findAll(new PageRequest(2, 1)));
//        request.setAttribute("mode" , "MODE_TASKS");
//        return "index";
//    }
}
