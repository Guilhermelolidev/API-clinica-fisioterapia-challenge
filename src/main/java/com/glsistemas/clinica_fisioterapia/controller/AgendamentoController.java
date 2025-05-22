package com.glsistemas.clinica_fisioterapia.controller;

import com.glsistemas.clinica_fisioterapia.domain.Agendamento;
import com.glsistemas.clinica_fisioterapia.dto.AgendamentoRequest;
import com.glsistemas.clinica_fisioterapia.dto.AgendamentoResponse;
import com.glsistemas.clinica_fisioterapia.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Agendamento> cancelar(@PathVariable Long id) {
        Agendamento agendamento =  agendamentoService.cancelarAgendamento(id);
        return ResponseEntity.ok(agendamento);
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<Agendamento> concluir(@PathVariable Long id) {
        Agendamento agendamento = agendamentoService.concluirAgendamento(id);
        return ResponseEntity.ok(agendamento);
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> agendar(@RequestBody @Valid AgendamentoRequest request){
        Agendamento agendamento = agendamentoService.criarAgendamento(
                request.idPaciente(),
                request.idFisioterapeuta(),
                request.dataHora(),
                request.observacoes()
        );

        AgendamentoResponse response = new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getPaciente().getNome(),
                agendamento.getFisioterapeuta().getNome(),
                agendamento.getDataHora(),
                agendamento.getStatus().name()
        );

        return ResponseEntity.created(URI.create("/api/agendamentos/" + agendamento.getId())).body(response);
    }
}
