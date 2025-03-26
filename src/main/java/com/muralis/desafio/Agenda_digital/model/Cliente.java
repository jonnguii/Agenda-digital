package com.muralis.desafio.Agenda_digital.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data //Evitar código repetido (Get, Set, ToString) - Lib chamada Lombok
@Entity //Informa que é uma entidade no Data Base
public class Cliente {

        @Id // gera id pro atributo
        @GeneratedValue(strategy = GenerationType.IDENTITY) // gera id auto-incremental
        private Long id;

        @Column(nullable = false) // not null
        String nome;

        @Column(nullable = false, unique = true) //not null + unico
        String cpf;

        private LocalDate dataNascimento; //Java usa LocalDate em vez de Date

        private String endereco;

        @OneToMany //Um cliente pode ter varios contatos
                (mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true) //Informamos que ja mapeamos a relação e que ao apagarmos um Cliemte, os contatos também apagam. Ao apagarmos um cliente, ele é deletado do DB.
        private List<Contato> contatos = new ArrayList<>(); //Cria uma lista de contatos
    }


