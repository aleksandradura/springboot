package com.example.service;

import com.example.dao.TaskRepository;
import com.example.model.Task;
import com.example.model.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    private static final int PAGE_SIZE = 3;

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(PageRequest pageRequest){
        List<Task> tasks = new ArrayList<>();
        for(Task task : taskRepository.findAll(pageRequest).getContent()) {
            tasks.add(task);
        }
        return tasks;
    }

    public Page<Task> getTaskLog(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return taskRepository.findAll(request);
    }
    public void save(Task task) {
        taskRepository.save(task);
    }
    public void delete(int id) {
        taskRepository.delete(id);
    }
    public Task findTask(int id) {
        return taskRepository.findOne(id);
    }
}
