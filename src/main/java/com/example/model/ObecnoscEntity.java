package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by test on 05.06.2017.
 */
@Entity(name = "obecnosc")
public class ObecnoscEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="\"ID\"")
    private int id;
    private String indeks;
    private String data;
    private String status;

    public ObecnoscEntity(){}
    public ObecnoscEntity(String indeks, String data, String status) {
        this.indeks = indeks;
        this.data = data;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ObecnoscEntity{" +
                "id=" + id +
                ", indeks='" + indeks + '\'' +
                ", data=" + data +
                ", status='" + status + '\'' +
                '}';
    }

}
