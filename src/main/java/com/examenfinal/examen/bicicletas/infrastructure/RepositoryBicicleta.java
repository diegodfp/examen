package com.examenfinal.examen.bicicletas.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenfinal.examen.bicicletas.domain.service.Bicicleta;

public interface RepositoryBicicleta extends JpaRepository<Bicicleta, Integer> {

}
