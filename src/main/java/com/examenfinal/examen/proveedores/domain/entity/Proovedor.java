package com.examenfinal.examen.proveedores.domain.entity;



import com.examenfinal.examen.ciudades.domain.entity.Ciudad;

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
public class Proovedor {


    @Id
    private int id;


    @Column
    private String nombre;

    @Column
    private String email;

    @Column
    private int contacto;

    @Column
    private int telefono;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "ciudadId", nullable = false)
    private  Ciudad ciudad;

}
