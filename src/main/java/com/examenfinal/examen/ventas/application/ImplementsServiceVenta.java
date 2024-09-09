package com.examenfinal.examen.ventas.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenfinal.examen.ventas.domain.entity.Venta;
import com.examenfinal.examen.ventas.domain.service.IServiceVenta;
import com.examenfinal.examen.ventas.infrastructure.RepositoryVenta;

import jakarta.transaction.Transactional;

@Service
public class ImplementsServiceVenta implements IServiceVenta {

    @Autowired
    private RepositoryVenta repositoryVenta;

    @Override
    @Transactional
    public Venta createVenta(Venta venta) {
        return repositoryVenta.save(venta);
    }

    @Override
    @Transactional
    public Optional<Venta> update(Integer id, Venta venta) {
        Optional<Venta> ventaOptional = repositoryVenta.findById(id);

        if (ventaOptional.isPresent()) {
            Venta ventaDb = ventaOptional.get();
            ventaDb.setFecha(venta.getFecha());
            ventaDb.setCliente(venta.getCliente());

            return Optional.of(repositoryVenta.save(ventaDb));
        }
        return ventaOptional;
    }

    @Override
    @Transactional
    public Optional<Venta> delete(Integer id) {
        Optional<Venta> ventaOptional = repositoryVenta.findById(id);

        ventaOptional.ifPresent(repositoryVenta::delete);
        return ventaOptional;
    }

    @Override
    public Optional<Venta> getVentaById(Integer id) {
        return repositoryVenta.findById(id);
    }

    @Override
    public List<Venta> getAllVenta() {
        return repositoryVenta.findAll();
    }
}
