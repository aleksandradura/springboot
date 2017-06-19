package com.example.service;

import com.example.dao.ObecnoscRepository;
import com.example.dao.StudentRepository;
import com.example.model.ObecnoscEntity;
import com.example.model.StudentEntity;
import com.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by test on 05.06.2017.
 */
@Service
@Transactional
public class ObecnoscService {

    private final ObecnoscRepository obecnoscRepository;
    private ObecnoscService studentRepository;

    public ObecnoscService(ObecnoscRepository obecnoscRepository) {
        this.obecnoscRepository = obecnoscRepository;
    }

    public void save(ObecnoscEntity obecnosc) {
        obecnoscRepository.save(obecnosc);
    }

//    public void saveStatus(StudentEntity obecnosc) {
//        studentRepository.save(obecnosc);
//    }
//
public List<ObecnoscEntity> findAllPresence(PageRequest pageRequest){
    List<ObecnoscEntity> obecnosci = new ArrayList<>();
    for(ObecnoscEntity task : obecnoscRepository.findAll(pageRequest).getContent()) {
        obecnosci.add(task);
    }
    return obecnosci;
}

}
