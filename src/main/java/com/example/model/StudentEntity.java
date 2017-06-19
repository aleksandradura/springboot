package com.example.model;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by test on 02.05.2017.
 */
@Entity(name = "student")
public class StudentEntity extends UserEntity{

    @NotNull
    @Size(min=6, max=6, message="uuu")
    private String indeks;


    private String kategoria;


//    private Set<Role> roles;


    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }


    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }


    public StudentEntity() {}
    public StudentEntity(String firstName, String lastName, String indeks, String password, String kategoria) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.indeks = indeks;
        this.kategoria = kategoria;
    }
//    @ManyToMany
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}
