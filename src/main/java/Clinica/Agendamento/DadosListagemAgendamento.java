package Clinica.Agendamento;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Clinica.Entities.Agendamento;

public record DadosListagemAgendamento(
		
		 LocalDate dataAgendamento,
	     LocalDateTime horaAgendamento,
	     String situacaoAgendamento,
	     String motivoAgendamento
	    
		
		
)


{
	
	public DadosListagemAgendamento(Agendamento agendamento) {
		this(agendamento.getDataAgendamento(), agendamento.getHoraAgendamento(), agendamento.getSituacaoAgendamento(),
			 agendamento.getMotivoAgendamento());
	}
	
	

	
	
}
