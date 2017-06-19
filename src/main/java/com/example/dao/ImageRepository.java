package com.example.dao;

import com.example.model.ImageEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by test on 19.06.2017.
 */
public interface ImageRepository extends CrudRepository<ImageEntity, Integer> {
}
