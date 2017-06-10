package com.example.dao;

import com.example.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by test on 01.05.2017.
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>, PagingAndSortingRepository<Task, Integer> {

}

