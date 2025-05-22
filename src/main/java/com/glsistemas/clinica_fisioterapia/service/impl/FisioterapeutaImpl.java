package com.glsistemas.clinica_fisioterapia.service.impl;

import com.glsistemas.clinica_fisioterapia.domain.Fisioterapeuta;
import com.glsistemas.clinica_fisioterapia.repository.FisioterapeutaRepository;
import com.glsistemas.clinica_fisioterapia.service.FisioterapeutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FisioterapeutaImpl implements FisioterapeutaService {
    @Autowired
    private FisioterapeutaRepository repo;

    @Override
    public Fisioterapeuta salvar(Fisioterapeuta fisioterapeuta) {
        return repo.save(fisioterapeuta);
    }
}
