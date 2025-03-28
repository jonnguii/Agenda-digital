package com.muralis.desafio.Agenda_digital.service;

import com.muralis.desafio.Agenda_digital.model.Cliente;

import java.util.List;
import java.util.Optional;

import com.muralis.desafio.Agenda_digital.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository; //Acesso ao banco

    public Cliente cadastrarCliente(Cliente cliente) {
        if (clienteRepository.existeCpf(cliente.getCpf())) {
            throw new RuntimeException("Já existe um cliente cadastrado com esse CPF");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarCliente() { //metodo de listar todos os clientes
        return clienteRepository.findAll();
    }

    public Cliente editarCliente(Cliente cliente) { //metodo com parametros de objeto contendo os novos dados inseridos na requisicao front
        Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getId()); // Optional chamado clienteExiste que busca um id passado na requisicao front no banco de dados

        if (clienteExistente.isPresent()) { //verifica se existe
            Cliente clienteAtualizado = clienteExistente.get(); //se existir, uma nova variavel recebe os valores antigos/atuais do banco
            //editar e inserir novos dados
            //a nova variavel seta novos dados a partir dos novos valores extraidos da requisicao front
            clienteAtualizado.setNome(cliente.getNome());
            clienteAtualizado.setDataNascimento(cliente.getDataNascimento());
            clienteAtualizado.setEndereco(cliente.getEndereco());
            clienteAtualizado.setCpf(cliente.getCpf());

            return clienteRepository.save(clienteAtualizado); //save no banco de dados
        } else {
            return cadastrarCliente((cliente)); //se não existir, cadastra
        }
    }


    public Cliente buscarCliente(Long id) { //metodo de encontrar cliente pelo cpf e retorna-lo
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);

        if (clienteEncontrado.isPresent()) {
            return clienteEncontrado.get();
        } else {
            throw new RuntimeException(("Cliente não encontrado por esse IO"));
        }
    }

    public void deletarCliente(Long id) { //metodo de deletar cliente pelo ID
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);

        if (clienteEncontrado.isPresent()) {
            clienteRepository.delete(clienteEncontrado.get());
        } else {
            throw new RuntimeException("Cliente não encontrado para excluir");
        }
    }
}
