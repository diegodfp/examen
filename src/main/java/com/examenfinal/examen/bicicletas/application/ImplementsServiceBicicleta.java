package com.examenfinal.examen.bicicletas.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenfinal.examen.bicicletas.domain.entity.IServiceBicicleta;
import com.examenfinal.examen.bicicletas.domain.service.Bicicleta;
import com.examenfinal.examen.bicicletas.infrastructure.RepositoryBicicleta;

import jakarta.transaction.Transactional;


@Service
public class ImplementsServiceBicicleta implements IServiceBicicleta {

    @Autowired
    RepositoryBicicleta repositoryBicicleta;

    @Override
    @Transactional
    public Bicicleta createBicicleta(Bicicleta bicicleta) {
        return repositoryBicicleta.save(bicicleta);
    }

   

    @Override
    @Transactional
    public Optional<Bicicleta> update(Integer id, Bicicleta product) {
        Optional<Bicicleta> BicicletaOptional = repositoryBicicleta.findById(id);

        if (BicicletaOptional.isPresent()) {
            
            Bicicleta bicicletaDb = BicicletaOptional.orElseThrow();
            
            bicicletaDb.setModelo(product.getModelo());
            bicicletaDb.setMarca(product.getMarca());
            bicicletaDb.setPrecio(product.getPrecio());
            bicicletaDb.setStock(product.getStock());
    
            return Optional.of(repositoryBicicleta.save(bicicletaDb));
            
        }
        return BicicletaOptional;
    }

    @Override
    @Transactional
    public Optional <Bicicleta> delete(Integer id) {
        Optional<Bicicleta> BicicletaOptional = repositoryBicicleta.findById(id);

        BicicletaOptional.ifPresent(bicicletaDb -> {
    
            repositoryBicicleta.delete(bicicletaDb);
    
        });
        return BicicletaOptional;
    }

    @Override
    @Transactional
    public Optional<Bicicleta> getBicicletaById(Integer id) {
        return repositoryBicicleta.findById(id);
    }

    @Override
    public List<Bicicleta> getAllBicicleta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBicicleta'");
    }

}






