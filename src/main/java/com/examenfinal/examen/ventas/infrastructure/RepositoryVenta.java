package com.examenfinal.examen.ventas.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examenfinal.examen.ventas.domain.entity.Venta;

public interface RepositoryVenta extends JpaRepository<Venta, Integer> {
}
