package com.glsistemas.clinica_fisioterapia.service;

import com.glsistemas.clinica_fisioterapia.domain.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> listar();
    Paciente salvar(Paciente paciente);
}
