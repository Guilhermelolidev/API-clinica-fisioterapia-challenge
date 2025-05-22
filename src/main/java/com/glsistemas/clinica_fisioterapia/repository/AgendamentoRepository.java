package com.glsistemas.clinica_fisioterapia.repository;

import com.glsistemas.clinica_fisioterapia.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByFisioterapeutaIdAndDataHora(Long fisioterapeutaId, LocalDateTime dataHora);

    @Query("""
        SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END
        FROM Agendamento a
        WHERE a.paciente.id = :pacienteId
          AND a.status = 'AGENDADO'
          AND DATE(a.dataHora) = :data
    """)
    boolean existsAgendamentoAtivoPorPacienteNoDia(
                @Param("pacienteId") Long pacienteId,
                @Param("data") LocalDate data
    );
}
