package com.examenfinal.examen.detalles_ventas.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenfinal.examen.detalles_ventas.domain.entity.DetalleVenta;
import com.examenfinal.examen.detalles_ventas.domain.service.IServiceDetalleVenta;
import com.examenfinal.examen.detalles_ventas.infrastructure.RepositoryDetalleVenta;

import jakarta.transaction.Transactional;

@Service
public class ImplementsServiceDetalleVenta implements IServiceDetalleVenta {

    @Autowired
    private RepositoryDetalleVenta repositoryDetalleVenta;

    @Override
    @Transactional
    public DetalleVenta createDetalleVenta(DetalleVenta detalleVenta) {
        return repositoryDetalleVenta.save(detalleVenta);
    }

    @Override
    @Transactional
    public Optional<DetalleVenta> update(Integer id, DetalleVenta detalleVenta) {
        Optional<DetalleVenta> detalleVentaOptional = repositoryDetalleVenta.findById(id);

        if (detalleVentaOptional.isPresent()) {
            DetalleVenta detalleVentaDb = detalleVentaOptional.get();
            detalleVentaDb.setCantidad(detalleVenta.getCantidad());
            detalleVentaDb.setVenta(detalleVenta.getVenta());
            detalleVentaDb.setBicicleta(detalleVenta.getBicicleta());

            return Optional.of(repositoryDetalleVenta.save(detalleVentaDb));
        }
        return detalleVentaOptional;
    }

    @Override
    @Transactional
    public Optional<DetalleVenta> delete(Integer id) {
        Optional<DetalleVenta> detalleVentaOptional = repositoryDetalleVenta.findById(id);

        detalleVentaOptional.ifPresent(repositoryDetalleVenta::delete);
        return detalleVentaOptional;
    }

    @Override
    public Optional<DetalleVenta> getDetalleVentaById(Integer id) {
        return repositoryDetalleVenta.findById(id);
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        return repositoryDetalleVenta.findAll();
    }
}
