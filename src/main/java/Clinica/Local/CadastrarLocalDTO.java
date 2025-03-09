package Clinica.Local;

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
	
	
	
	
	


}
