package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by test on 05.06.2017.
 */
@Entity(name = "sekcja")
public class KategoriaEntity {

    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=205, allocationSize=12)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name="\"ID\"",unique=true)
    private int idKategoria;
    private String kategoria;

    public KategoriaEntity(){}

    public KategoriaEntity(String kategoria) {
        this.kategoria = kategoria;
    }

    public int getIdKategoria() {
        return idKategoria;
    }

    public void setIdKategoria(int idKategoria) {
        this.idKategoria = idKategoria;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "KategoriaEntity{" +
                "idKategoria=" + idKategoria +
                ", kategoria='" + kategoria + '\'' +
                '}';
    }
}
