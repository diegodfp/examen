package com.examenfinal.examen.clientes.infrastructure;



import org.springframework.data.jpa.repository.JpaRepository;

import com.examenfinal.examen.clientes.domain.entity.Cliente;

public interface RepositoryCliente  extends JpaRepository <Cliente , Long> {

}
