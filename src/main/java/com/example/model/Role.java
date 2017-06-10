package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by test on 29.05.2017.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name="id")
    private Long id;
    private String name;
    private Set<StudentEntity> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @ManyToMany(mappedBy = "roles")
//    public Set<StudentEntity> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<StudentEntity> users) {
//        this.users = users;
//    }
}
