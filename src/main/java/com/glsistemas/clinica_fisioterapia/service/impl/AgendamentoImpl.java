package com.glsistemas.clinica_fisioterapia.service.impl;

import com.glsistemas.clinica_fisioterapia.domain.Agendamento;
import com.glsistemas.clinica_fisioterapia.domain.Fisioterapeuta;
import com.glsistemas.clinica_fisioterapia.domain.Paciente;
import com.glsistemas.clinica_fisioterapia.domain.enums.StatusAgendamento;
import com.glsistemas.clinica_fisioterapia.repository.AgendamentoRepository;
import com.glsistemas.clinica_fisioterapia.repository.FisioterapeutaRepository;
import com.glsistemas.clinica_fisioterapia.repository.PacienteRepository;
import com.glsistemas.clinica_fisioterapia.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class AgendamentoImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private FisioterapeutaRepository fisioterapeutaRepository;

    @Override
    public Agendamento criarAgendamento(Long idPaciente,
                                        Long idFisioterapeuta,
                                        LocalDateTime dataHora,
                                        String observacoes
    ) {

        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

        Fisioterapeuta fisioterapeuta = fisioterapeutaRepository.findById(idFisioterapeuta)
                .orElseThrow(() -> new IllegalArgumentException("Fisioterapeuta não encontrado"));

        validarHorario(dataHora);

        LocalDate dataDoAgendamento = dataHora.toLocalDate();

        if (agendamentoRepository.existsAgendamentoAtivoPorPacienteNoDia(idPaciente, dataDoAgendamento)) {
            throw new IllegalStateException("Paciente já possui um agendamento ativo nesse dia.");
        }

        if(agendamentoRepository.existsByFisioterapeutaIdAndDataHora(idFisioterapeuta,dataHora)) {
            throw new IllegalArgumentException("Já existe um agendamento com esse fisioterapeuta nesse horário.");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setPaciente(paciente);
        agendamento.setFisioterapeuta(fisioterapeuta);
        agendamento.setDataHora(dataHora);
        agendamento.setObservacoes(observacoes);
        agendamento.setStatus(StatusAgendamento.AGENDADO);

        return agendamentoRepository.save(agendamento);
    }

    public Agendamento cancelarAgendamento(Long idAgendamento) {
        Agendamento existente = agendamentoRepository.findById(idAgendamento)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));

        if(existente.getStatus() != StatusAgendamento.AGENDADO) {
            throw new IllegalArgumentException("Somente agendamentos com status Agendado podem ser alterados ou cancelados");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setId(existente.getId());
        agendamento.setPaciente(existente.getPaciente());
        agendamento.setFisioterapeuta(existente.getFisioterapeuta());
        agendamento.setDataHora(existente.getDataHora());
        agendamento.setObservacoes(existente.getObservacoes());
        agendamento.setStatus(StatusAgendamento.CANCELADO);
        agendamentoRepository.save(agendamento);
        return agendamento;
    }

    public Agendamento concluirAgendamento(Long idAgendamento) {
        Agendamento existente = agendamentoRepository.findById(idAgendamento)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));

        if(existente.getStatus() != StatusAgendamento.AGENDADO) {
            throw new IllegalArgumentException("Somente agendamentos com status Agendado podem ser alterados ou cancelados");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setId(existente.getId());
        agendamento.setPaciente(existente.getPaciente());
        agendamento.setFisioterapeuta(existente.getFisioterapeuta());
        agendamento.setDataHora(existente.getDataHora());
        agendamento.setObservacoes(existente.getObservacoes());
        agendamento.setStatus(StatusAgendamento.CONCLUIDO);
        agendamentoRepository.save(agendamento);
        return agendamento;
    }

    public void validarHorario(LocalDateTime dataHora) {
        LocalTime horario = dataHora.toLocalTime();
        LocalTime inicio = LocalTime.of(8,0);
        LocalTime fim = LocalTime.of(18,0);

        if(horario.isBefore(inicio) || horario.isAfter(fim)) {
            throw new IllegalArgumentException("Horário do agendamento deve estar entre 08:00 e 18:00.");
        }
    }
}
