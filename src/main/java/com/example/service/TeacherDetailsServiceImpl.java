package com.example.service;

import com.example.dao.StudentRepository;
import com.example.dao.TeacherRepository;
import com.example.model.StudentEntity;
import com.example.model.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 31.05.2017.
 */
public class TeacherDetailsServiceImpl implements UserDetailsService {
    private static final int PAGE_SIZE = 3;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        TeacherEntity teacherEntity = teacherRepository.findByLastName(username);
        if(teacherEntity == null) {
            throw new UsernameNotFoundException(
                    "Nie znaleziono uzytkownika '" + username + " '. ");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
        return new User(teacherEntity.getLastName(), teacherEntity.getPassword(), authorities);
    }

}
