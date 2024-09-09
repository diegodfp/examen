package com.examenfinal.examen.detalles_ventas.domain.service;

import java.util.List;
import java.util.Optional;

import com.examenfinal.examen.detalles_ventas.domain.entity.DetalleVenta;

public interface IServiceDetalleVenta {
    DetalleVenta create(DetalleVenta detalleVenta);

    Optional<DetalleVenta> update(Integer id, DetalleVenta product);

    Optional <DetalleVenta> delete(Integer id);

    Optional<DetalleVenta> getById(Integer id);

}
