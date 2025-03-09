package Clinica.Agendamento;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Clinica.Entities.Agendamento;
import Clinica.Entities.Local;

public record RealizarAgendamentoDTO(
		
		
        LocalDate dataAgendamento,
        LocalDateTime horaAgendamento,
        String situacaoAgendamento,
        String motivoAgendamento,
        String localAgendamento,
        String enderecoLocal
) {
    public RealizarAgendamentoDTO(Agendamento agendamento, Local local) {
        this(
            agendamento.getDataAgendamento(),
            agendamento.getHoraAgendamento(),
            agendamento.getSituacaoAgendamento(),
            agendamento.getMotivoAgendamento(),
            local.getNomeLocal(),
            local.getEnderecoLocal()
        );
    }
}
