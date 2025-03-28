package com.muralis.desafio.Agenda_digital.repository;

import com.muralis.desafio.Agenda_digital.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { //JpaRepo é a interface do Spring que ja tem metodos prontos pra salvar, listar e deletar
    Optional<Cliente> findByCpf(String cpf);

    boolean existeCpf(String cpf);
}



