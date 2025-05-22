package com.glsistemas.clinica_fisioterapia.service.impl;

import com.glsistemas.clinica_fisioterapia.domain.Paciente;
import com.glsistemas.clinica_fisioterapia.repository.PacienteRepository;
import com.glsistemas.clinica_fisioterapia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteImpl implements PacienteService {
    @Autowired
    private PacienteRepository repo;

    @Override
    public List<Paciente> listar() {
        return repo.findAll();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        return repo.save(paciente);
    }
}
