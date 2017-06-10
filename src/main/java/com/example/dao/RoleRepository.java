package com.example.dao;

import com.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by test on 29.05.2017.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
