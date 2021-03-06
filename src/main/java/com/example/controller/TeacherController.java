package com.example.controller;

import com.example.dao.ImageRepository;
import com.example.dao.TaskRepository;
import com.example.dao.TeacherRepository;
import com.example.model.*;
import com.example.service.ObecnoscService;
import com.example.service.UserService;
import com.example.service.TaskService;
import com.example.service.TeacherService;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
//@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TaskRepository taskRepository;
    private TeacherEntity teacherEntity;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ObecnoscService obecnoscService;
    private StudentEntity studentEntity;
    private ObecnoscEntity obecnoscEntity;
    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {this.teacherRepository = teacherRepository;}

    @Autowired
    private ImageRepository imageRepository;


    @RequestMapping(value = "/search")
    public String Search(@RequestParam("searchString") String searchString, HttpSession session, HttpServletRequest request) {

        if(searchString != null){
            //studentService.findStudent(searchString);
            request.setAttribute("a", studentService.findStudent(searchString));

        }
        return "search";
    }

//    @RequestMapping(path = "/login", method = RequestMethod.GET)
//    public String login() {
//        return "login";
//    }

//    @RequestMapping(path = "/teacher2/{teacherId}", method = RequestMethod.GET)
//    public String teacher2(@PathVariable(value="teacherId") int teacherId, Model model) {
//        TeacherEntity tas =  teacherRepository.findById(teacherId);
//        model.addAttribute(tas);
//        return "teacherHomePage";
//
//    }


    @RequestMapping(value = "/teacher2/{pageNumber}", method = RequestMethod.GET)
    public String teacher2(@PathVariable Integer pageNumber, Model model) {
        Page<StudentEntity> page = studentService.getStudentLog(pageNumber);
        //List<Task> taski;
        //taski = taskService.findAll(new PageRequest(3, 3));
        //model.addAttribute("taski", taski);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("taski", page.getContent());
        model.addAttribute("pageLog", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "teacherHomePage";
    }
    @RequestMapping(path = "/delete-student", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam int id, HttpServletRequest request) {
        studentService.delete(id);
        request.setAttribute("students", studentService.findAllS(new PageRequest(2, 1)));
        request.setAttribute("mode" , "MODE_ST");
        return "teacherHomePage";
    }
    @RequestMapping(path = "/save-status", method = RequestMethod.POST)
    public String saveStatus(@ModelAttribute ObecnoscEntity obecnosc, ModelAndView model, BindingResult bindingResult, HttpServletRequest request) {
        model.addObject("indeks", obecnosc);
        model.addObject("datepicker" , obecnosc);
        model.addObject("status" , obecnosc);
        obecnoscService.save(obecnosc);
//  request.setAttribute("mode" , "MODE_STATUS");
        return "redirect:/teacher2/1";
    }
    @RequestMapping(path = "/send-message", method = RequestMethod.GET)
    public String sendMessage(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {
        return "sendMessage";
    }
    @RequestMapping(path = "/save-taskStudent", method = RequestMethod.POST)
    public String saveTaskStudent(@ModelAttribute Task task, ModelAndView model, BindingResult bindingResult, HttpServletRequest request) {
        model.addObject("indeks", task);
        model.addObject("name" , task);
        model.addObject("description" , task);
        taskService.save(task);
        //request.setAttribute("taskis", taskService.findAll(new PageRequest(2, 1)));
        return "redirect:/teacher2/1";
    }


//    @RequestMapping(path = "/all-tasks", method = RequestMethod.GET)
//    public String allTasks(HttpServletRequest request) {
//        request.setAttribute("tasks", taskService.findAll(new PageRequest(2, 1)));
//        request.setAttribute("mode" , "MODE_TASKS");
//        return "index";
//    }
//    @GetMapping("/teacher2/{id}")
//    public String findOwner(@PathVariable String id, Model model) {
//        TeacherEntity owner = teacherService.findTeacher(id);
//        model.addAttribute("owner", owner);
//        return "teacherHomePage";
//    }

    @RequestMapping(path = "/teacher2", method = RequestMethod.GET)
    public String proba(Model model) {

        return "redirect:/teacher2/1";
    }

    @RequestMapping(path = "/data-teacher/{teacherId}", method = RequestMethod.GET)
    public String data(@PathVariable int teacherId, Model model) {
        teacherRepository.findById(teacherId);
        model.addAttribute("last", teacherEntity.getLastName());
        model.addAttribute("first" , teacherEntity.getFirstName());
        //model.addAttribute("t" , teacherService.findById(teacherId));
        return "dataTeacher";
    }
//    @RequestMapping(path = "/teacher2/logout")
//    public String logout() {
//        //request.setAttribute("tasks", taskService.findAll(new PageRequest(2, 1)));
//        //request.setAttribute("mode" , "MODE_TASKS");
//        return "redirect:/";
//    }

    @RequestMapping(path = "/teacher2/imageUpload")
    public String uploadImage(@RequestParam("file")MultipartFile file,
                              Model model) throws IOException {
        String data = Base64.encode(file.getBytes());
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setData(data);
        imageRepository.save(imageEntity);
        return "redirect:/teacher2";
    }

}
