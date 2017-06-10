package com.example.model;

import org.springframework.security.crypto.codec.Base64;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by test on 31.05.2017.
 */
@Entity(name = "teacher")
public class TeacherEntity implements Serializable{
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=205, allocationSize=12)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name="\"ID\"",unique=true,nullable=false)
        private int teacherId;
        private String firstName;
        private String lastName;
        private String password;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "avatar")
    private byte[] avatar;

//    public byte[] getImg() {
//        return avatar;
//    }
//
//    public void setImg(byte[] avatar) {
//        this.avatar = avatar;
//    }

//    @SuppressWarnings("unused")
//    private String base64;
//
//    @Transient
//    public String getBase64() {
//        return this.base64 = Base64.encode(this.avatar);
//    }

//    public void setBase64(String base64) {
//        this.base64 = base64;
//    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getTeacherId() {

        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TeacherEntity() {}

    public TeacherEntity(String firstName, String lastName, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
}
