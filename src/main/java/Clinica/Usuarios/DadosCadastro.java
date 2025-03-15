package Clinica.Usuarios;

import java.time.LocalDate;

public record DadosCadastro(
    String login,
    String cpf,
    String numeroUsuario,
    String emailUsuario,
    LocalDate dataNascimento,
    String senha
    

)

{

	
}
   

