package Clinica.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Clinica.Agendamento.RealizarAgendamentoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="agendamentoCliente")
@Table(name="agendamentoCliente")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;                           
	private LocalDate dataAgendamento;
	private LocalDateTime horaAgendamento;
	private String situacaoAgendamento;
	private String motivoAgendamento;
	
	
	public Agendamento(RealizarAgendamentoDTO agendamento) {
		this.dataAgendamento = agendamento.dataAgendamento();
		this.horaAgendamento = agendamento.horaAgendamento();
		this.situacaoAgendamento = agendamento.situacaoAgendamento();
		this.motivoAgendamento = agendamento.motivoAgendamento();
	}
	
	
	
	@ManyToOne
	@JoinColumn(name="local_id")
	Local local;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
	
	


