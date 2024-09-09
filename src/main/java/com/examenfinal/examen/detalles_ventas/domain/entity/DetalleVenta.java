package com.examenfinal.examen.detalles_ventas.domain.entity;



import com.examenfinal.examen.bicicletas.domain.service.Bicicleta;
import com.examenfinal.examen.ciudades.domain.entity.Ciudad;
import com.examenfinal.examen.ventas.domain.entity.Venta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "detalles_ventas")
@Entity
public class DetalleVenta {
    
    @Id
    private int id;

    @Column
    private int cantidad;

    @Column
    private double precioUnitario;



    @ManyToOne
    @JoinColumn(name = "ventaId", nullable = false)
    private  Venta venta;

    @ManyToOne
    @JoinColumn(name = "bicicletaId", nullable = false)
    private  Bicicleta bicicleta;


}
