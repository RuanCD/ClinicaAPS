package Clinica.Local;

import java.time.LocalDate;

import Clinica.Entities.Local;


public record DadosListagemLocalDTO (
		
		String nomeLocal,
		String enderecoLocal,
		String telefoneLocal,
		LocalDate horarioAbertura,
	    LocalDate horarioFechamento,
		String situacaoLocal,
		String foto1,
		String foto2,
		String foto3
		
)




{
	
	public DadosListagemLocalDTO(Local local, String foto1, String foto2, String foto3) {
		this(local.getNomeLocal(), local.getEnderecoLocal(), local.getTelefoneLocal(),
			 local.getHorarioAbertura(),local.getHorarioFechamento(),local.getSituacaoLocal(),
			 foto1, foto2, foto3);
	}
	
	
	

}
