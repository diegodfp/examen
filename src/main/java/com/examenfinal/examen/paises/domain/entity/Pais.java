package com.examenfinal.examen.paises.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pais {

    @Id
    private int id;


    @Column
    private String nombre;

}
