package com.example.HttpSecurity;

import com.example.dao.StudentRepository;
import com.example.model.Role;
import com.example.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by test on 29.05.2017.
 */
@EnableWebMvcSecurity
public class Configuration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                .antMatchers("/webjars/font-awesome/**").permitAll()
                        .antMatchers("/webjars/bootstrap/**").permitAll()
                        .antMatchers("/sass/**").permitAll()
                        .antMatchers("/webjars/jquery/**").permitAll()
                        .antMatchers("/registration").permitAll()
                        .antMatchers("/teacher2").hasRole("USER")
                        .and()
                        .formLogin().loginProcessingUrl("/j_spring_security_check").permitAll()
                        .loginPage("/loginTeacher")
                        .and()
                        .logout()
                        .logoutSuccessUrl("/login?logout").permitAll()
                        .logoutUrl("/logout").permitAll();
    }

}