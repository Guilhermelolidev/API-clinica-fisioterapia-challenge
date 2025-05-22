package com.glsistemas.clinica_fisioterapia.repository;

import com.glsistemas.clinica_fisioterapia.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
