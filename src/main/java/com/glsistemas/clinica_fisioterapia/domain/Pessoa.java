package com.glsistemas.clinica_fisioterapia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String nome;

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(nullable = false)
    protected String telefone;

    @Column(nullable = false, unique = true, length = 11)
    protected String cpf;
}
