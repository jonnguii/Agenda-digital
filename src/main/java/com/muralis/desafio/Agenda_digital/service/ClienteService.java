package com.muralis.desafio.Agenda_digital.service;

import com.muralis.desafio.Agenda_digital.model.Cliente;

import java.util.Optional;
import com.muralis.desafio.Agenda_digital.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) { //metodo de "criar cliente"
        Optional<Cliente> clienteExiste = clienteRepository.findBycpf(cliente.getCpf());

        if (clienteExiste.isPresent()) {
            throw new RuntimeException("Já existe um cliente com este CPF");
        }
        return clienteRepository.save(cliente);
    }
}