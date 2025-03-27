package com.muralis.desafio.Agenda_digital.service;

import com.muralis.desafio.Agenda_digital.model.Cliente;
import java.util.List;
import java.util.Optional;
import com.muralis.desafio.Agenda_digital.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository; //Acesso ao banco

    public Cliente salvarCliente(Cliente cliente) { //metodo de "criar cliente"
        Optional<Cliente> clienteExiste = clienteRepository.findByCpf(cliente.getCpf());

        if (clienteExiste.isPresent()) {
            throw new RuntimeException("Já existe um cliente com este CPF");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarCliente() { //metodo de listar todos os clientes
        return clienteRepository.findAll();
        }

    public Cliente encontrarCliente(Cliente cliente) { //metodo de encontrar cliente pelo cpf e retorna-lo
        Optional<Cliente> clienteEncontrado = clienteRepository.findByCpf(cliente.getCpf());

        if (clienteEncontrado.isPresent()) {
            return clienteEncontrado.get();
        } else {
            throw new RuntimeException(("Cliente não encontrado por esse CPF"));
        }
    }

    public void deletarCliente (Cliente cliente) { //metodo de deletar cliente pelo cpf
        Optional<Cliente> clienteEncontrado = clienteRepository.findByCpf(cliente.getCpf());

        if (clienteEncontrado.isPresent()) {
            clienteRepository.delete(clienteEncontrado.get());
        } else {
            throw new RuntimeException("Cliente não encontrado por esse CPF");
        }
    }
}
