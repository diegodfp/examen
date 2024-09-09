package com.examenfinal.examen.compras.domain.entity;

import java.sql.Date;

import com.examenfinal.examen.marca.domain.entity.Marca;
import com.examenfinal.examen.proveedores.domain.entity.Proovedor;

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
public class Compra {

    @Id
    private int id;

    @Column
    private Date fecha;

    @Column
    private Double total;


    @ManyToOne
    @JoinColumn(name = "proovedorId", nullable = false)
    private  Proovedor proovedor;

}
