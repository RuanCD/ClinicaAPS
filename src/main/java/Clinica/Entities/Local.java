package Clinica.Entities;

import java.time.LocalDate;

import Local.CadastrarLocalDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="locais")
@Table(name="locais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Local {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeLocal;
	private String enderecoLocal;
	private String telefoneLocal;
	private LocalDate horarioAbertura;
	private LocalDate horarioFechamento;
	private String situacaoLocal;
	@Lob
    private byte[] foto1;
	@Lob
	private byte[] foto2;
	@Lob
	private byte[] foto3;
	
	public Local(CadastrarLocalDTO localDTO) {
		this.nomeLocal = localDTO.nomeLocal();
		this.enderecoLocal = localDTO.enderecoLocal();
		this.telefoneLocal = localDTO.telefoneLocal();
		this.horarioAbertura = localDTO.horarioAbertura();
		this.horarioFechamento = localDTO.horarioFechamento();
		this.situacaoLocal = localDTO.situacaoLocal();
	}

}
