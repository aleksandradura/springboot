package com.example.service;

import com.example.dao.StudentRepository;
import com.example.dao.TeacherRepository;
import com.example.model.Role;
import com.example.model.StudentEntity;
import com.example.model.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by test on 31.05.2017.
 */
public class TeacherDetailsServiceImpl implements UserDetailsService {
    private static final int PAGE_SIZE = 3;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    //@Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TeacherEntity teacherEntity = teacherRepository.findByLastName(username);

//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for(Role role : teacherEntity.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//
//        }
//        return new org.springframework.security.core.userdetails.User(teacherEntity.getLastName(), teacherEntity.getPassword(), grantedAuthorities);
        if(teacherEntity == null) {
            throw new UsernameNotFoundException(
                    "Nie znaleziono uzytkownika '" + username + " '. ");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(teacherEntity.getLastName(), teacherEntity.getPassword(), authorities);
    }

}
