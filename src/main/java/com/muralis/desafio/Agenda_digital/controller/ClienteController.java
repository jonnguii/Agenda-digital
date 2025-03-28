package com.muralis.desafio.Agenda_digital.controller;

import com.muralis.desafio.Agenda_digital.model.Cliente;
import com.muralis.desafio.Agenda_digital.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //Simbolizar que a classe é um Controlador para requicoes http
@RequiredArgsConstructor //Utiliza a ferramenta Lombok, que evita criaçãoo de código manual e repetitivo
@RequestMapping ("/clientes") //Endpoint base
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping //Endpoint salvar/criar novo cliente
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) { //Informa ao spring que os dados são capturados do corpo da requiscao http, pois eles são novos
        return clienteService.cadastrarCliente(cliente); //chama o método de salvarcCliente do service
    }

    @GetMapping //Endpoint listar/buscar clientes
    public List<Cliente> listarClientes() { //Cria uma lista
        return clienteService.listarCliente(); //chama o método de listarCliente do service para a lista
    }

    @PutMapping //Endpoint editar cliente
    public Cliente editarCliente(@RequestBody Cliente cliente) { //Informa ao spring que os dados editados virão da requisição https
    return clienteService.editarCliente(cliente); //chama o método de editarCliente do service

    }

    @GetMapping("/{id}") //Endpoint buscar cliente por id
    public Cliente buscarCliente (@PathVariable Long id) { //Informa ao spring que o id vem da URL que será passada
        return clienteService.buscarCliente(id); //chama o método de buscarCliente do service
    }

    @DeleteMapping("/{id}") //Endpoint deletar cliente por ID
    public void deletarCliente (@PathVariable Long id) { //Informa ao spring que o cliente será deletado pelo id da URL da requisicao http
        clienteService.deletarCliente(id); //chama o método de deletarCliente do service
    }
}

