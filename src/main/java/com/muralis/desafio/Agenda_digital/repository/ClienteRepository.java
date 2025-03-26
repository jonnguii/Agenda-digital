package com.muralis.desafio.Agenda_digital.repository;

import com.muralis.desafio.Agenda_digital.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.swing.text.html.Option;
import java.util.Optional;

    @Repository
    public interface ClienteRepository extends JpaRepository<Cliente, Long> { //JpaRepo é a interface do Spring que ja tem metodos prontos pra salvar, listar e deletar
        Optional<Cliente> findBycpf(String cpf); //Retorna um Optional porque pode ou não encontrar um cliente, ja que ele precisa existir, diferente do contato
    }



