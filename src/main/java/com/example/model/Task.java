package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by test on 01.05.2017.
 */
@Entity(name="t_tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="\"ID\"")
    private int id;
    private String name;
    private String description;
    private String indeks;

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Task(){}

    public Task(String name, String description, String indeks) {
        this.name = name;
        this.description = description;
        this.indeks = indeks;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", indeks=" + indeks +
                '}';
    }
}
