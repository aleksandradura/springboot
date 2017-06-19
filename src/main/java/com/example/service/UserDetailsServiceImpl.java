package com.example.service;

import com.example.dao.StudentRepository;
import com.example.dao.TeacherRepository;
import com.example.dao.UserRepository;
import com.example.model.Role;
import com.example.model.StudentEntity;
import com.example.model.TeacherEntity;
import com.example.model.UserEntity;
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
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by test on 29.05.2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
            UserEntity userEntity = userRepository.findByLastName(username);
        System.out.println("nthethe");
            if(userEntity == null) {
                throw new UsernameNotFoundException(
                        "Nie znaleziono uzytkownika '" + username + " '. ");
            }

                    return new User(userEntity.getLastName(), userEntity.getPassword(), convert(userEntity.getRoles()));
    }

    public Collection<GrantedAuthority> convert(Set<Role> roles) {
        return roles.stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
    }

}
