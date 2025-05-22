package com.glsistemas.clinica_fisioterapia.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fisioterapeuta extends Pessoa {
    @Column(nullable = false, unique = true)
    private String crf;

    private String especializacao;
}
