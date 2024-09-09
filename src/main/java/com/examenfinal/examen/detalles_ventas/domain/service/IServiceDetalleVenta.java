package com.examenfinal.examen.detalles_ventas.domain.service;

import java.util.List;
import java.util.Optional;
import com.examenfinal.examen.detalles_ventas.domain.entity.DetalleVenta;

public interface IServiceDetalleVenta {

    DetalleVenta createDetalleVenta(DetalleVenta detalleVenta);

    Optional<DetalleVenta> update(Integer id, DetalleVenta detalleVenta);

    Optional<DetalleVenta> delete(Integer id);

    Optional<DetalleVenta> getDetalleVentaById(Integer id);

    List<DetalleVenta> getAllDetalleVenta();
}
