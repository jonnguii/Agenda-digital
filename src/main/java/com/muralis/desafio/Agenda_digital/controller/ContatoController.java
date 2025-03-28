package com.muralis.desafio.Agenda_digital.controller;

import com.muralis.desafio.Agenda_digital.model.Contato;
import com.muralis.desafio.Agenda_digital.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contatos")
public class ContatoController {
    private final ContatoService contatoService;


    @PostMapping
    public Contato cadastrarContato(@RequestBody Contato contato) {
        return contatoService.cadastrarContato(contato);
    }

    @GetMapping
    public List<Contato> listarContatos() {
        return contatoService.listarContatos();
    }

    @PutMapping
    public Contato editarContato(@RequestBody Contato contato) {
        return contatoService.editarContato(contato);
    }

    @DeleteMapping
    public void deletarContato(@PathVariable Long id) {
        contatoService.deletarContato(id);

    }
}