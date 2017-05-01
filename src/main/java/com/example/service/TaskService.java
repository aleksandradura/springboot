package com.example.service;

import com.example.dao.TaskRepository;
import com.example.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 01.05.2017.
 */
@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        List<Task> tasks = new ArrayList<>();
        for(Task task : taskRepository.findAll()) {
            tasks.add(task);
        }
        return tasks;
    }
}
