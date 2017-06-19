package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by test on 02.05.2017.
 */
@Entity(name = "student")
public class StudentEntity implements Serializable {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=205, allocationSize=12)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(unique=true,nullable=false)
    private int studentId;
    @NotNull
    @Size(min=3, max=12)
    private String firstName;
    @NotNull
    @Size(min=3, max=12, message="zzzz")
    private String lastName;
    @NotNull
    @Size(min=6, max=6, message="uuu")
    private String indeks;
    @NotNull
    @Size(min=3, max=20, message="{password.size}")
    private String password;

    private String kategoria;


//    private Set<Role> roles;

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", indeks='" + indeks + '\'' +
                ", password='" + password + '\'' +
                ", kategoria='" + kategoria + '\'' +
                '}';
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudentEntity() {}
    public StudentEntity(String firstName, String lastName, String indeks, String password, String kategoria) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.indeks = indeks;
        this.password = password;
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
