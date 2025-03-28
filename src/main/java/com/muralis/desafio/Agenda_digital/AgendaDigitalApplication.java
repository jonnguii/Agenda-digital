package com.muralis.desafio.Agenda_digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class AgendaDigitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendaDigitalApplication.class, args);
    }

}
