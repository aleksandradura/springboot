package com.example.service;

import com.example.dao.KategoriaRepository;
import com.example.dao.ObecnoscRepository;
import com.example.model.KategoriaEntity;
import com.example.model.ObecnoscEntity;
import com.example.model.StudentEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 05.06.2017.
 */
@Service
@Transactional
public class KategoriaService {
    KategoriaRepository kategoriaRepository;

    public KategoriaService(KategoriaRepository kategoriaRepository) {
        this.kategoriaRepository = kategoriaRepository;
    }

    public void save(KategoriaEntity kategoria) {
        kategoriaRepository.save(kategoria);
    }

public List<KategoriaEntity> findAllCategories(PageRequest pageRequest){
    List<KategoriaEntity> categories = new ArrayList<>();
    for(KategoriaEntity task : kategoriaRepository.findAll(pageRequest).getContent()) {
        categories.add(task);
    }
    return categories;
}

}
