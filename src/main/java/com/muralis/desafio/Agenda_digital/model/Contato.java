package com.muralis.desafio.Agenda_digital.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) //armazenar valor como STRING no banco e marcar atributo com tipo especial Enum
    private TipoContato tipo; //atributo do enum TipoContato

    @Column(nullable = false)
    private String valor;

    private String observacao;

    @ManyToOne //Muitos contatos, mas pertence a um unico cliente
    @JoinColumn(name = "cliente_id", nullable = false)
    //foreign key "cliente_id" not null = precisa obrigatoriamente estar ligado a um cliente
    private Cliente cliente; //Objeto do tipo Cliente que vira a coluna "cliente_id"
}
