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

    public Contato cadastrarContato (Contato contato) { //metodo de salvar contato presente na lista
        List<Contato> contatoExiste = contatoRepository.findByCliente(contato.getCliente());

        if (!contatoExiste.isEmpty()) { //se não estiver vazia, ja existe contato
            throw new RuntimeException("Esse contato já esta salvo!");

        }
        return contatoRepository.save(contato); //save no banco de dados
    }


    public List<Contato> listarContatos(){ //metodo de listar todos os contatos
        return contatoRepository.findAll();
    }

    public Contato editarContato (Contato contatos) { //metodo com parametro de objeto com novos valores inseridos na requisicao front
        Optional<Contato> contatoExistente = contatoRepository.findById(contatos.getId()); //verificar se o objeto é null

        if (contatoExistente.isPresent()) {
            Contato contatoAtualizado = contatoExistente.get(); // objeto novo que recebe os valores do banco

            //editar e inserir novos dados
            //a nova variavel seta novos dados a partir dos novos valores extraidos da requisicao front
            contatoAtualizado.setTipo(contatos.getTipo());
            contatoAtualizado.setValor(contatos.getValor());
            contatoAtualizado.setObservacao(contatos.getObservacao());

            return contatoRepository.save(contatoAtualizado); //save no banco de dados
        } else {
            return cadastrarContato(contatos); //se não existir, cadastra
        }
    }

    public void deletarContato (Long id){
        Optional<Contato> contatoExiste = contatoRepository.findById(id);

        if (contatoExiste.isPresent()) {
            contatoRepository.delete(contatoExiste.get());
        } else {
            throw new RuntimeException("Esse contato não esta salvo");

        }
    }
}
