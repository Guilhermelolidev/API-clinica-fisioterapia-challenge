package com.glsistemas.clinica_fisioterapia.service;

import com.glsistemas.clinica_fisioterapia.domain.Agendamento;

import java.time.LocalDateTime;

public interface AgendamentoService {
    Agendamento criarAgendamento(Long idPaciente, Long idFisioterapeuta,
                       LocalDateTime dataHora, String observacoes);
    Agendamento cancelarAgendamento(Long idAgendamento);
    Agendamento concluirAgendamento(Long idAgendamento);
}
