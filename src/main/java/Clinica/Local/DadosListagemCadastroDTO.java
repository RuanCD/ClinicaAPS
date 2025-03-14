package Clinica.Local;

import java.time.LocalDate;
import java.util.Base64;

import Clinica.Entities.Local;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DadosListagemCadastroDTO{

	private String nomeLocal;
	private String enderecoLocal;
	private String telefoneLocal;
	private LocalDate horarioAbertura;
	private LocalDate horarioFechamento;
	private String situacaoLocal;
	private String foto1;
	private String foto2;
	private String foto3;
	
	public DadosListagemCadastroDTO(Local local) {
		this.nomeLocal = local.getNomeLocal();
		this.enderecoLocal = local.getEnderecoLocal();
		this.telefoneLocal = local.getTelefoneLocal();
		this.horarioAbertura = local.getHorarioAbertura();
		this.horarioFechamento = local.getHorarioFechamento();
		this.situacaoLocal = local.getSituacaoLocal();
	}
	
}
