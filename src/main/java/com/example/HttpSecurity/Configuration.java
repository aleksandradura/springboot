package com.example.HttpSecurity;

import com.example.dao.StudentRepository;
import com.example.model.Role;
import com.example.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by test on 29.05.2017.
 */
@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                .antMatchers("/webjars/font-awesome/**").permitAll()
                        .antMatchers("/webjars/bootstrap/**").permitAll()
                        .antMatchers("/webjars/jquery/**").permitAll()
                        //.antMatchers("/teacher2").permitAll()
                        .antMatchers("/student2").hasAuthority("STUDENT")
                        .antMatchers("/teacher2").hasAuthority("TEACHER")
                        .antMatchers("/**").permitAll()
                        .and()
                        .formLogin().usernameParameter("username").passwordParameter("password").loginProcessingUrl("/j_spring_security_check")
                        .loginPage("/login").permitAll()
                        .and()
                        .logout()
                        .logoutSuccessUrl("/login?logout").permitAll()
                        .logoutUrl("/logout").permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }


}
