package com.example.dao;

import com.example.model.KategoriaEntity;
import com.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by test on 05.06.2017.
 */
@Repository
public interface KategoriaRepository extends CrudRepository<KategoriaEntity, String> {
    //KategoriaEntity findByKategoria(String kategoria);
}
