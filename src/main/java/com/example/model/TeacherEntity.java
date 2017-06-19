package com.example.model;

import lombok.Data;
import org.springframework.security.crypto.codec.Base64;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by test on 31.05.2017.
 */
@Entity(name = "teacher")
@Data
public class TeacherEntity extends UserEntity{

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "avatar")
    private byte[] avatar;
 //   private Set<Role> roles;

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


}
