package Local;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import Clinica.Entities.Local;

public record CadastrarLocalDTO(
		
		
	 String nomeLocal,
	 String enderecoLocal,
	 String telefoneLocal,
	 LocalDate horarioAbertura,
     LocalDate horarioFechamento,
	 String situacaoLocal,
	 MultipartFile foto1,
	 MultipartFile foto2,
	 MultipartFile foto3
		
)




{
	
	public CadastrarLocalDTO(Local local) {
		this(local.getNomeLocal(), local.getEnderecoLocal(), 
			 local.getTelefoneLocal(), local.getHorarioAbertura(), 
			 local.getHorarioFechamento(), local.getSituacaoLocal(), null, null, null);
	}
	
	
	


}
