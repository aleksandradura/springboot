package com.example.Controller;

import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by test on 01.05.2017.
 */
@Controller
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "index";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String allTasks(){
        return taskService.findAll().toString();
    }
}
