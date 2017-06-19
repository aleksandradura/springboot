package com.example.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by test on 19.06.2017.
 */

@Entity
@Data
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Lob
    private String data;
}
