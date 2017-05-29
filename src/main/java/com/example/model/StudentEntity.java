package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

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
    private String firstName;
    private String lastName;
    private String indeks;
    private String password;

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", indeks='" + indeks + '\'' +
                ", password='" + password + '\'' +
                '}';
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
    public StudentEntity(String firstName, String lastName, String indeks, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.indeks = indeks;
        this.password = password;
    }
}
