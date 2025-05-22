package com.glsistemas.clinica_fisioterapia.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente extends Pessoa {

    @Column(nullable = false)
    private LocalDate dataNascimento;

    private String planoSaude;

}
