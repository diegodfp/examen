package com.examenfinal.examen.ventas.domain.service;

import java.util.List;
import java.util.Optional;
import com.examenfinal.examen.ventas.domain.entity.Venta;

public interface IServiceVenta {

    Venta createVenta(Venta venta);

    Optional<Venta> update(Integer id, Venta venta);

    Optional<Venta> delete(Integer id);

    Optional<Venta> getVentaById(Integer id);

    List<Venta> getAllVenta();
}
