package com.examenfinal.examen.bicicletas.domain.entity;

import java.util.List;
import java.util.Optional;

import com.examenfinal.examen.bicicletas.domain.service.Bicicleta;

public interface IServiceBicicleta {

    Bicicleta createBicicleta(Bicicleta bicicleta);

    Optional<Bicicleta> update(Integer id, Bicicleta product);

    Optional <Bicicleta> delete(Integer id);

    Optional<Bicicleta> getBicicletaById(Integer id);

    List<Bicicleta> getAllBicicleta();

}
