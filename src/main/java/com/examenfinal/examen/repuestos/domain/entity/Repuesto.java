package com.examenfinal.examen.repuestos.domain.entity;




import com.examenfinal.examen.clientes.domain.entity.Cliente;
import com.examenfinal.examen.marca.domain.entity.Marca;
import com.examenfinal.examen.modelo.domain.entity.Modelo;
import com.examenfinal.examen.proveedores.domain.entity.Proovedor;

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
public class Repuesto {


    @Id
    private int id;

    @Column
    private String nombre;

    @Column
    private String descripcion;


    @Column
    private double precio;


    @Column
    private int stock;

    @ManyToOne
    @JoinColumn(name = "proovedorId", nullable = false)
    private  Proovedor proovedor;

    @ManyToOne
    @JoinColumn(name = "modeloId", nullable = false)
    private  Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "marcaId", nullable = false)
    private  Marca marca;

}
