package com.glsistemas.clinica_fisioterapia.dto;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long id,
        String nomePaciente,
        String nomeFisioterapeuta,
        LocalDateTime dataHora,
        String status
) {
}
