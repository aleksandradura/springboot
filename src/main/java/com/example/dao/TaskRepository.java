package com.example.dao;

import com.example.model.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by test on 01.05.2017.
 */
public interface TaskRepository extends CrudRepository<Task, Integer>{
}
