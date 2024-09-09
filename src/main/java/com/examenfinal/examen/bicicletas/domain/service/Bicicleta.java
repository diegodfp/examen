package com.examenfinal.examen.bicicletas.domain.service;

import com.examenfinal.examen.marca.domain.entity.Marca;
import com.examenfinal.examen.modelo.domain.entity.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Bicicleta {

    
    @Id
    private int id;


    @Column
    private Double precio;


    @Column
    private int stock;

    @ManyToOne
    @JoinColumn(name = "modeloId", nullable = false)
    private Modelo modelo;


    @ManyToOne
    @JoinColumn(name = "marcaId", nullable = false)
    private Marca marca;
}
