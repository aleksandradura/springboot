package com.example.controller;

import com.example.dao.TaskRepository;
import com.example.dao.TeacherRepository;
import com.example.model.Task;
import com.example.model.TeacherEntity;
import com.example.service.StudentService;
import com.example.service.TaskService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
//@RequestMapping("/teacher")
public class TeacherController {

    private TeacherRepository teacherRepository;
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {this.teacherRepository = teacherRepository;}

    //    @RequestMapping(path = "/loginTeacher/{eventID}", method = RequestMethod.GET)
//    public String data(@PathVariable String eventId, HttpServletRequest request) {
//        request.setAttribute("tas", teacherService.findTeacher(eventId));
//        return "teacherHomePage";
//    }

    @RequestMapping(value = "/search")
    public String Search(@RequestParam("searchString") String searchString, HttpSession session, HttpServletRequest request) {

        if(searchString != null){
            //studentService.findStudent(searchString);
            request.setAttribute("a", studentService.findStudent(searchString));

        }

        return "search";
    }

    @RequestMapping(path = "/loginTeacher", method = RequestMethod.GET)
    public String loginTeacher() {
        return "loginTeacher";
    }
    @RequestMapping(path = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadStatus";

    }
//    @RequestMapping(path = "/teacher2" , method = RequestMethod.POST)
//    public String teacher(TeacherEntity teacherEntity) { return "teacherHomePage/" + teacherEntity.getLastName();}

//    @RequestMapping(path = "/teacher2/{teacherId}", method = RequestMethod.GET)
//    public String teacher2(@PathVariable(value="teacherId") int teacherId, Model model) {
//        TeacherEntity tas =  teacherRepository.findByTeacherId(teacherId);
//        model.addAttribute(tas);
//        return "teacherHomePage";
//
//    }

    @RequestMapping(value = "/teacher2/{pageNumber}", method = RequestMethod.GET)
    public String teacher2(@PathVariable Integer pageNumber, Model model) {
        Page<Task> page = taskService.getTaskLog(pageNumber);
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
    @RequestMapping(path = "/all-tasks", method = RequestMethod.GET)
    public String allTasks(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll(new PageRequest(2, 1)));
        request.setAttribute("mode" , "MODE_TASKS");
        return "index";
    }
//    @GetMapping("/teacher2/{id}")
//    public String findOwner(@PathVariable String id, Model model) {
//        TeacherEntity owner = teacherService.findTeacher(id);
//        model.addAttribute("owner", owner);
//        return "teacherHomePage";
//    }

    @RequestMapping(path = "/teacher2", method = RequestMethod.GET)
    public String proba(Model model) {

        return "teacherHomePage";
    }

//    @RequestMapping(value = "/admin/addEvent", method = RequestMethod.POST)
//    public String adminAddEvent(@ModelAttribute("eventForm") TeacherEntity eventForm, BindingResult bindingResult, Model model,
//                                @RequestParam(value = "img") CommonsMultipartFile[] img) throws IOException {
//        eventValidator.setEditable(false);
//        eventValidator.validate(eventForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("gunTypeList", eventService.getListOfGuns());
//            model.addAttribute("refereeList", refereeService.getListOfReferees());
//            return "/admin/addEvent";
//        }
//
//        if (img != null && img.length > 0) {
//            for (CommonsMultipartFile aFile : img) {
//                eventForm.setImg(aFile.getBytes());
//            }
//        }
//
//        eventService.save(eventForm);
//
//        return "redirect:/admin/eventList";
//    }
    @RequestMapping(path = "/data-teacher/{teacherId}", method = RequestMethod.GET)
    public String data(@PathVariable int teacherId, Model model) {

        model.addAttribute("t", teacherService.findByTeacherId(teacherId));

        return "dataTeacher";
    }
}
