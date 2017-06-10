package com.example.service;

import com.example.dao.StudentRepository;
import com.example.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 29.05.2017.
 */

@Service
public class StudentDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
            StudentEntity studentEntity = studentRepository.findByIndeks(username);
            if(studentEntity == null) {
                throw new UsernameNotFoundException(
                        "Nie znaleziono uzytkownika '" + username + " '. ");
            }
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    return new User(studentEntity.getIndeks(), studentEntity.getPassword(), authorities);
    }
}
