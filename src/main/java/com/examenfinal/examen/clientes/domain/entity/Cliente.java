package com.examenfinal.examen.clientes.domain.entity;

import com.examenfinal.examen.ciudades.domain.entity.Ciudad;
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
public class Cliente {

    @Id
    private int id;


    @Column
    private String nombre;

    @Column
    private String email;

    @Column
    private int telefono;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "ciudadId", nullable = false)
    private  Ciudad ciudad;

}
