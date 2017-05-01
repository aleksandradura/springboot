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
    @SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=205, allocationSize=12)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name="\"ID\"",unique=true,nullable=false)
    private int id;
    private String name;
    private String description;
    private boolean finished;

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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Task(){}

    public Task(String name, String description, boolean finished) {
        super();
        this.name = name;
        this.description = description;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", finished=" + finished +
                '}';
    }
}
