package com.examenfinal.examen.ciudades.domain.entity;

import com.examenfinal.examen.paises.domain.entity.Pais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ciudad {


    @Id
    private int id;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "paisId", nullable = false)
    private  Pais pais;


}
