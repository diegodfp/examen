package com.examenfinal.examen.ventas.domain.entity;


import java.sql.Date;

import com.examenfinal.examen.clientes.domain.entity.Cliente;

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
@Builder
@Entity
public class Venta {

    @Id
    private int id;

    @Column
    private Date fecha;


    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    private  Cliente cliente;


}
