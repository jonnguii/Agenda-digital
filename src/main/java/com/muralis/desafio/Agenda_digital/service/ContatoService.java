package com.muralis.desafio.Agenda_digital.service;

import com.muralis.desafio.Agenda_digital.model.Contato;
import com.muralis.desafio.Agenda_digital.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository; //Acesso ao banco. Sem necessidade de escrever SQL por conta do JPA

    public Contato salvarContato (Contato contato) { //metodo de salvar contato presente na lista
        List<Contato> contatoExiste = contatoRepository.findByCliente(contato.getCliente());

        if (!contatoExiste.isEmpty()) { //se não estiver vazia, ja existe contato
            throw new RuntimeException("Esse contato já esta salvo!");

        }
        return contatoRepository.save(contato);
    }

    public List<Contato> listarContatos(){
        return contatoRepository.findAll();
    }

    public void deletarContato (Contato contato){
        Optional<Contato> contatoExiste = contatoRepository.findById(contato.getId());

        if (contatoExiste.isPresent()) {
            contatoRepository.delete(contatoExiste.get());
        } else {
            throw new RuntimeException("Esse contato não esta salvo");

        }
    }
}
