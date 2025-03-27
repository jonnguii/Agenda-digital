package com.muralis.desafio.Agenda_digital.repository;

import com.muralis.desafio.Agenda_digital.model.Cliente;
import com.muralis.desafio.Agenda_digital.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findByCliente(Cliente cliente); //Retorna uma lista de contatos existente, busca contatos pelo cliente a partir de um objeto
}