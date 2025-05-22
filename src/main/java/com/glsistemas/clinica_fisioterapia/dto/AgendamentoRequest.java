package com.glsistemas.clinica_fisioterapia.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequest(
        @NotNull Long idPaciente,
        @NotNull Long idFisioterapeuta,
        @NotNull @Future LocalDateTime dataHora,
        String observacoes
) {
}
