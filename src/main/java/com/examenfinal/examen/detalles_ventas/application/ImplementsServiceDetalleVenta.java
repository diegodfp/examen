package com.examenfinal.examen.detalles_ventas.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenfinal.examen.bicicletas.domain.service.Bicicleta;
import com.examenfinal.examen.detalles_ventas.domain.entity.DetalleVenta;
import com.examenfinal.examen.detalles_ventas.domain.service.IServiceDetalleVenta;
import com.examenfinal.examen.detalles_ventas.infrastructure.RepositoryDetallesVenta;

import jakarta.transaction.Transactional;

@Service
public class ImplementsServiceDetalleVenta implements IServiceDetalleVenta{

    @Autowired
    RepositoryDetallesVenta repositoryDetallesVenta;

    @Override
    @Transactional
    public DetalleVenta create(DetalleVenta detalleVenta) {
        return repositoryDetallesVenta.save(detalleVenta);
    }

    @Override
    @Transactional
    public Optional<DetalleVenta> update(Integer id, DetalleVenta product) {
         Optional<DetalleVenta> BicicletaOptional = repositoryDetallesVenta.findById(id);

        if (BicicletaOptional.isPresent()) {
            
            DetalleVenta bicicletaDb = BicicletaOptional.orElseThrow();
            
            bicicletaDb.setVenta(product.getVenta());
            bicicletaDb.setBicicleta(product.getBicicleta());
            bicicletaDb.setCantidad(product.getCantidad());
            bicicletaDb.setPrecioUnitario(product.getPrecioUnitario());
    
            return Optional.of(repositoryDetallesVenta.save(bicicletaDb));
            
        }
        return BicicletaOptional;
    }

    @Override
    public Optional<DetalleVenta> delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<DetalleVenta> getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }


}
