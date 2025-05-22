package com.glsistemas.clinica_fisioterapia.repository;

import com.glsistemas.clinica_fisioterapia.domain.Fisioterapeuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FisioterapeutaRepository extends JpaRepository<Fisioterapeuta, Long> {
}
