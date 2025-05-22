package com.glsistemas.clinica_fisioterapia.controller;

import com.glsistemas.clinica_fisioterapia.domain.Fisioterapeuta;
import com.glsistemas.clinica_fisioterapia.service.FisioterapeutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fisioterapeutas")
public class FisioterapeutaController {

    @Autowired
    private FisioterapeutaService service;

    @PostMapping
    public Fisioterapeuta salvar(@RequestBody Fisioterapeuta fisioterapeuta) {
        return service.salvar(fisioterapeuta);
    }
}
