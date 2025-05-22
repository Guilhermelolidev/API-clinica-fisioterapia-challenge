package com.glsistemas.clinica_fisioterapia.controller;

import com.glsistemas.clinica_fisioterapia.domain.Paciente;
import com.glsistemas.clinica_fisioterapia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public List<Paciente> listar() {
        return service.listar();
    }

    @PostMapping
    public Paciente cadastrar(@RequestBody Paciente paciente) {
        return service.salvar(paciente);
    }
}
