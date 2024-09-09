package com.examenfinal.examen.detalles_ventas.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenfinal.examen.detalles_ventas.domain.entity.DetalleVenta;

public interface RepositoryDetallesVenta extends JpaRepository<DetalleVenta, Integer> {

}
