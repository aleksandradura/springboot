package com.example.dao;

import com.example.model.ObecnoscEntity;
import com.example.model.Role;
import com.example.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ObecnoscRepository extends CrudRepository<ObecnoscEntity, String>, PagingAndSortingRepository<ObecnoscEntity, String> {
    ObecnoscEntity findByIndeks(String indeks);
    //ObecnoscEntity findByDate(Date date);
}
